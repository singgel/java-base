package com.hks.classLoader;

/**
 * 第三步，定义一个有main函数入口的public类来做验证
 */
public class TestClassLoaderDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class thisCls = TestClassLoaderDemo.class;
        MyClassLoader myClassLoader = new MyClassLoader();
        System.out.println(thisCls.getClassLoader());
        System.out.println(myClassLoader.getParent());
        try {
            //用自定义的类装载器来装载类,这是动态扩展的一种途径
            Class cls2 = myClassLoader.loadClass("com.hks.eightsortingalgorithms.classLoader.TestBeLoader");
            System.out.println(cls2.getClassLoader());
            TestBeLoader test=(TestBeLoader)cls2.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第四步，查看运行结果
     */

}
