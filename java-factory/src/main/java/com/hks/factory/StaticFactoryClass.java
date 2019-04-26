package com.hks.factory;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 */
public class StaticFactoryClass {

    public static Boolean valueOf(Boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

}
