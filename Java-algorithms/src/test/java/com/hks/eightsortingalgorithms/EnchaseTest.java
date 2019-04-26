package com.hks.eightsortingalgorithms;

/**
 * @author Dale
 * java中的自动装箱与拆箱
 * 简单一点说，装箱就是自动将基本数据类型转换为包装器类型；拆箱就是自动将包装器类型转换为基本数据类型。
 */
public class EnchaseTest {

    public static void main(String[] args) {
        /**
         Integer i1 = 128;  // 装箱，相当于 Integer.valueOf(128);
         int t = i1; //相当于 i1.intValue() 拆箱
         System.out.println(t);
         */

        /**
         对于–128到127（默认是127）之间的值,被装箱后，会被放在内存里进行重用
         但是如果超出了这个值,系统会重新new 一个对象
         */
        Integer i1 = 200;
        Integer i2 = 200;

        /**
         注意 == 与 equals的区别
         == 它比较的是对象的地址
         equals 比较的是对象的内容
         */
        if(i1==i2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        Integer a=123;
        Integer b=123;
        System.out.println(a==b);        // 输出 true
        System.out.println(a.equals(b));  // 输出 true
    }

}
