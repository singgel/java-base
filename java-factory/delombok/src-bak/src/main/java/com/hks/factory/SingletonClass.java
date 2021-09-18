package com.hks.factory;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 * <p>
 * 使用构造函数，调用其中的方法，则实例化一个类是必不可少的步奏，
 * <p>
 * 而是使用静态工厂方法，则可以对对象进行重复利用，这个特点在单例模式中使用颇多
 *
 * 都是线程安全的
 */
public class SingletonClass {

    private SingletonClass() {
    }

    private static SingletonClass singletonClass = null;

    // 加锁机制
    public static SingletonClass getSingletonClass() {
        if (singletonClass == null) {
            synchronized (SingletonClass.class) {
                if (singletonClass == null) {
                    singletonClass = new SingletonClass();
                }
            }
        }
        return singletonClass;
    }

    // 终极版本：volatile
    private static volatile SingletonClass instance;
    public static SingletonClass getSingleInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    // Happens-Before
    private static class SingleHolder{
        public static SingletonClass instance = new SingletonClass();
    }

    public static SingletonClass getInstance(){
        return SingleHolder.instance;
    }
}
