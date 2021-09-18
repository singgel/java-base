package com.hks.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  第一步，首先定义自己的类装载器，从ClassLoader继承，重写它的findClass方法，
 *  至于为什么要这么做，大家如果看过笔记三就知道，双亲委托模式下，
 *  如果parent没办法loadClass，bootStrap也没把办法loadClass的时候，jvm是会调用ClassLoader对象或者它子类对象的findClass来装载。
 */
public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = getByteArray(name);
        if (data == null) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, data, 0, data.length);
    }

    private byte[] getByteArray(String name){
        String filePath =   name.replace(".", File.separator);
        byte[] buf = null;
        try {
            FileInputStream in = new FileInputStream(filePath);
            buf = new byte[in.available()];
            in.read(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }


}
