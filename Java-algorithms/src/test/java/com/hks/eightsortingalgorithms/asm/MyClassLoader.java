package com.hks.eightsortingalgorithms.asm;

import org.objectweb.asm.Opcodes;
/**
 * @Author: hekuangsheng
 * @Date: 2018/10/19
 *
 * 自定义ClassLoader
 */
public class MyClassLoader extends ClassLoader implements Opcodes {


    public MyClassLoader() {
        super();
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public Class<?> defineClass(String name, byte[] b){
        return super.defineClass(name, b, 0, b.length);
    }

}

