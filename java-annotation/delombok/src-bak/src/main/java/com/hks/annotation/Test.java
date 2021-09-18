package com.hks.annotation;

@Column(name = "heks",setFuncName = "heksFunc")

public class Test {

    @FruitColor
    private String colnum;

    @org.junit.Test
    public void test(){
        Apple apple = new Apple();
        System.out.print(apple.getAppleColor());
        System.out.print(apple.getAppleName());
    }

}
