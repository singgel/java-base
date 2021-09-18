package som.hks.oom;

/**
 * 软件开发过程中，应该尽可能避免使用短命的大对象。
 * 可以使用参数-XX:PetenureSizeThreshold 设置大对象直接进入年老代的阈值。
 * 当对象的大小超过这个值时，将直接在年老代分配。
 * 参数-XX:PetenureSizeThreshold 只对串行收集器和年轻代并行收集器有效，并行回收收集器不识别这个参数
 *
 * -XX:+PrintGCDetails –Xmx20M –Xms20MB
 * -XX:+PrintGCDetails –Xmx20M –Xms20MB -XX:PetenureSizeThreshold=1000000
 */
public class BigObj2Old {

    public static void main(String[] args){
        byte[] b;
        b = new byte[1024*1024];//分配一个 1MB 的对象
    }

}
