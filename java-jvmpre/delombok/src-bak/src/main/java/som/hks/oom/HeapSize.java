package som.hks.oom;

import java.util.Vector;

/**
 *
 -XX:MinHeapFreeRatio 参数用来设置堆空间最小空闲比例，默认值是 40。
 当堆空间的空闲内存小于这个数值时，JVM 便会扩展堆空间。

 -XX:MaxHeapFreeRatio 参数用来设置堆空间最大空闲比例，默认值是 70。
 当堆空间的空闲内存大于这个数值时，便会压缩堆空间，得到一个较小的堆。

 当-Xmx 和-Xms 相等时，-XX:MinHeapFreeRatio 和-XX:MaxHeapFreeRatio 两个参数无效
 * -XX:+PrintGCDetails -Xms10M -Xmx40M -XX:MinHeapFreeRatio=40 -XX:MaxHeapFreeRatio=50
 * -XX:+PrintGCDetails -Xms40M -Xmx40M -XX:MinHeapFreeRatio=40 -XX:MaxHeapFreeRatio=50
 */
public class HeapSize {
    public static void main(String args[]) throws InterruptedException{
        Vector v = new Vector();
        while(true){
            byte[] b = new byte[1024*1024];
            v.add(b);
            if(v.size() == 10){
                v = new Vector();
            }
            Thread.sleep(1);
        }
    }
}
