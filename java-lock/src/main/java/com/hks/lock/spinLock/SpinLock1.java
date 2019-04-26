/*
 * 文件名：SpinLock1.java
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

public class SpinLock1 {
    private AtomicReference<Thread> owner =new AtomicReference<Thread>();
    private int count =0;
    public void lock(){
        Thread current = Thread.currentThread();
        if(current==owner.get()) {
            count++;
            return ;
        }

        while(!owner.compareAndSet(null, current)){

        }
    }
    public void unlock (){
        Thread current = Thread.currentThread();
        if(current==owner.get()){
            if(count!=0){
                count--;
            }else{
                owner.compareAndSet(current, null);
            }

        }

    }
}

