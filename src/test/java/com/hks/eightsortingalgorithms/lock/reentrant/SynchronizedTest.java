/*
 * 文件名：SynchrosizedTest.java
 * 版权：Copyright by www.yiche.com
 * 描述：
 * 修改人：hekuangsheng
 * 修改时间：2019/3/26
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.hks.eightsortingalgorithms.lock.reentrant;

public class SynchronizedTest implements Runnable {
    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        SynchronizedTest ss = new SynchronizedTest();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
