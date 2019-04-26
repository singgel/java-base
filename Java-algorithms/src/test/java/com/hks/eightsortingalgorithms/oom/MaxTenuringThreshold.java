package com.hks.eightsortingalgorithms.oom;

/**
 * 这个阈值的最大值可以通过参数-XX:MaxTenuringThreshold 来设置，默认值是 15。
 * 虽然-XX:MaxTenuringThreshold 的值可能是 15 或者更大，但这不意味着新对象非要达到这个年龄才能进入年老代。
 * 事实上，对象实际进入年老代的年龄是虚拟机在运行时根据内存使用情况动态计算的，这个参数指定的是阈值年龄的最大值。
 * 即，实际晋升年老代年龄等于动态计算所得的年龄与-XX:MaxTenuringThreshold 中较小的那个
 *
 * -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=2
 *
 * -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=1
 */
public class MaxTenuringThreshold {
    public static void main(String args[]){
        byte[] b1,b2,b3;
        b1 = new byte[1024*512];
        b2 = new byte[1024*1024*2];
        b3 = new byte[1024*1024*4];
        b3 = null;
        b3 = new byte[1024*1024*4];
    }
}
