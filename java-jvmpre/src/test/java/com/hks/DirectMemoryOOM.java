package com.hks;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

//-XX:MaxDirectMemorySize=10M
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception{
        Field unsafefield = Unsafe.class.getDeclaredFields()[0];
        unsafefield.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafefield.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
