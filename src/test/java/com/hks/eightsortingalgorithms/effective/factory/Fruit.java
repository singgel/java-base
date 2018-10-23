package com.hks.eightsortingalgorithms.effective.factory;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23

 * 食物的子类，水果
 */
public class Fruit implements Food {
    @Override
    public void introduce() {
        System.out.println("i am the fruit");
    }
}
