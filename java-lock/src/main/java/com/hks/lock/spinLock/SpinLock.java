/*
 * 文件名：SpinLock.java
 * 版权：Copyright by www.yiche.com
 * 描述：
 * 修改人：hekuangsheng
 * 修改时间：2019/3/26
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.hks.lock.spinLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 对于自旋锁来说，
 1、若有同一线程两调用lock() ，会导致第二次调用lock位置进行自旋，产生了死锁
 说明这个锁并不是可重入的。（在lock函数内，应验证线程是否为已经获得锁的线程）
 2、若1问题已经解决，当unlock（）第一次调用时，就已经将锁释放了。实际上不应释放锁。
 （采用计数次进行统计）
 */
public class SpinLock {
    private AtomicReference<Thread> owner =new AtomicReference<Thread>();

    public void lock(){
        Thread current = Thread.currentThread();
        while(!owner.compareAndSet(null, current)){
        }
    }

    public void unlock (){
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }
}

