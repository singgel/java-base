/*
 * 文件名：SpinLock1Test.java
 * 版权：Copyright by www.yiche.com
 * 描述：
 * 修改人：hekuangsheng
 * 修改时间：2019/3/26
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.hks.lock.spinLock;

public class SpinLock1Test implements Runnable{
    SpinLock1 lock = new SpinLock1();

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    public void run() {
        get();
    }

    public static void main(String[] args) {
        SpinLock1Test ss = new SpinLock1Test();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
