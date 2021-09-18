# 合理估算java的线程池大小及队列数
## 原理分析
>原文：http://ifeve.com/how-to-calculate-threadpool-size/

先来一个天真的估算方法：假设要求一个系统的TPS（Transaction Per Second或者Task Per Second）至少为20，然后假设每个Transaction由一个线程完成，继续假设平均每个线程处理一个Transaction的时间为4s。那么问题转化为：

如何设计线程池大小，使得可以在1s内处理完20个Transaction？

计算过程很简单，每个线程的处理能力为0.25TPS，那么要达到20TPS，显然需要20/0.25=80个线程。

很显然这个估算方法很天真，因为它没有考虑到CPU数目。一般服务器的CPU核数为16或者32，如果有80个线程，那么肯定会带来太多不必要的线程上下文切换开销。

再来第二种简单的但不知是否可行的方法（N为CPU总核数）：

- 如果是CPU密集型应用，则线程池大小设置为N+1；
- 如果是IO密集型应用，则线程池大小设置为2N+1；

如果一台服务器上只部署这一个应用并且只有这一个线程池，那么这种估算或许合理，具体还需自行测试验证。

第三种方法是在服务器性能IO优化中发现的一个估算公式：

>最佳线程数目 = （（线程等待时间 + 线程CPU时间）/ 线程CPU时间 ）* CPU数目

比如平均每个线程CPU运行时间为0.5s，而线程等待时间（非CPU运行时间，比如IO）为1.5s，CPU核心数为8，那么根据上面这个公式估算得到：((0.5+1.5)/0.5)*8=32。这个公式进一步转化为：

>最佳线程数目 = （线程等待时间与线程CPU时间之比 + 1）* CPU数目

可以得出一个结论：

- 线程CPU时间所占比例越高，需要越少线程。
- 线程等待时间所占比例越高，需要越多线程。

上一种估算方法也和这个结论相合。

一个系统最快的部分是CPU，所以决定一个系统吞吐量上限的是CPU。增强CPU处理能力，可以提高系统吞吐量上限。但根据短板效应，真实的系统吞吐量并不能单纯根据CPU来计算。那要提高系统吞吐量，就需要从“系统短板”（比如网络延迟、IO）着手：

- 尽量提高短板操作的并行化比率，比如多线程下载技术
- 增强短板能力，比如用NIO替代IO

第一条可以联系到Amdahl定律，这条定律定义了串行系统并行化后的加速比计算公式：

>加速比=优化前系统耗时 / 优化后系统耗时

加速比越大，表明系统并行化的优化效果越好。

Addahl定律还给出了系统并行度、CPU数目和加速比的关系：

加速比为Speedup，系统串行化比率（指串行执行代码所占比率）为F，CPU数目为N：

>Speedup <= 1 / (F + (1-F)/N)

当N足够大时，串行化比率F越小，加速比Speedup越大。

是否使用线程池就一定比使用单线程高效呢？

答案是否定的，比如Redis就是单线程的，但它却非常高效，基本操作都能达到十万量级/s。

从线程这个角度来看，部分原因在于多线程带来线程上下文切换开销，单线程就没有这种开销。

当然“Redis很快”更本质的原因在于：Redis基本都是内存操作，这种情况下单线程可以很高效地利用CPU。而多线程适用场景一般是：存在相当比例的IO和网络操作。

**所以即使有上面的估算方法，也许看似合理，但实际上也未必合理，都需要结合系统真实情况（比如是IO密集型或者是CPU密集型或者是纯内存操作）和硬件环境（CPU、内存、硬盘读写速度、网络状况等）来不断尝试达到一个符合实际的合理估算值。**

## 源码分析
### `PoolSizeCalculator`类
#### `calculateBoundaries`方法
入口类，计算线程池大小和队列数。

接收两个参数，CPU负载和队列总内存的大小（bytes）
#### `calculateMemoryUsage`方法
计算单个任务的内存大小，计算方法：
1. 手动GC
2. 计算可用内存大小m0
3. 创建一个队列，并往里面放1000个任务
4. 再次GC
5. 计算可用内存大小m1
6. `(m1 - m0) / 1000`即每个任务的大小
>参考：<https://www.javaspecialists.eu/archive/Issue029.html>
#### `calculateOptimalCapacity`方法
计算队列数，计算公式：**队列总内存**/**单个任务的内存**。

接收一个参数：队列总内存的大小。

#### `start`方法
计算*执行3秒的任务*所消耗CPU的实际使用时间。
>参考：<https://www.javaspecialists.eu/archive/Issue124.html>
#### `calculateOptimalThreadCount`方法
计算线程池大小。
计算公式：CPU核数 * （1 + 线程等待时间/线程CPU时间）
#### `collectGarbage`方法
循环手动GC
### `SimplePoolSizeCaculator`类
`PoolSizeCalculator`类的一个实现，计算*CPU负载1*，*队列总内存的大小为100k左右*的*IO密集型*的线程池大小和队列数
#### `AsyncIOTask`类
IO密集型的一个例子

## 使用方法
```bash
# 下载
git clone https://github.com/sunshanpeng/dark_magic.git
# 编译
cd dark_magic && mvn package
# 执行
java -jar target/dark_magic-1.0-SNAPSHOT.jar
```
控制台打印示例
```$xslt
Target queue memory usage (bytes): 100000
createTask() produced threadpool.AsyncIOTask which took 40 bytes in a queue
Formula: 100000 / 40
* Recommended queue capacity (bytes): 2500
Number of CPU: 4
Target utilization: 1
Elapsed time (nanos): 3000000000
Compute time (nanos): 125000000
Wait time (nanos): 2875000000
Formula: 4 * 1 * (1 + 2875000000 / 125000000)
* Optimal thread count: 96
```
> 如果不修改队列内存大小和任务，队列数可能都是2500