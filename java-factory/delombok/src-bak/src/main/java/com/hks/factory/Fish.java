package com.hks.factory;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23

 * 定义食物的子类:鱼
 */
public class Fish implements Food{

    @Override
    public void introduce() {
        System.out.println("i am a fish");
    }
}
