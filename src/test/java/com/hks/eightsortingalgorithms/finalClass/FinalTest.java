package com.hks.eightsortingalgorithms.finalClass;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 *
 * true
 * false
 *
 * 为什么第一个比较结果为true，而第二个比较结果为fasle。
 *
 * 这里面就是final变量和普通变量的区别了，当final变量是基本数据类型以及String类型时，
 * 如果在编译期间能知道它的确切值，则编译器会把它当做编译期常量使用。
 *
 * 也就是说在用到该final变量的地方，相当于直接访问的这个常量，不需要在运行时确定。
 */
public class FinalTest {

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }

}
