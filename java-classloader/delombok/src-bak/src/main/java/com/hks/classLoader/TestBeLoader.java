package com.hks.classLoader;

/**
 * 第二步，定义一个类，专门用于被装载，这里我们定义了一个静态代码块，待会用到它
 */
public class TestBeLoader {

    static{
        System.out.println("TestBeLoader init");
    }
    public void sayHello(){
        System.out.println("hello");
    }

}
