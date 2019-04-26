package com.hks.eightsortingalgorithms.staticClass;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 *
 * 33
 *
 * 这里面主要考察队this和static的理解。this代表什么？
 * this代表当前对象，那么通过new ThisClass()来调用printValue的话，当前对象就是通过new ThisClass()生成的对象。
 * 而static变量是被对象所享有的，因此在printValue中的this.value的值毫无疑问是33。
 *
 * 静态成员变量虽然独立于对象，但是不代表不可以通过对象去访问，所有的静态方法和静态变量都可以通过对象访问（只要访问权限足够）
 */
public class ThisClass {

    static int value = 33;

    public static void main(String[] args) throws Exception {
        new ThisClass().printValue();
    }

    private void printValue() {
        int value = 3;
        System.out.println(this.value);
    }

}
