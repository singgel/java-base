package com.hks.eightsortingalgorithms.valuePass;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/29
 * <p>
 * 值传递：
 * 在方法被调用时，实参通过形参把它的内容副本传入方法内部，
 * 此时形参接收到的内容是实参值的一个拷贝，
 * 因此在方法内对形参的任何操作，都仅仅是对这个副本的操作，不影响原始值的内容。
 */
public class ValuePassTest {

    public static void valueCrossTest(int age, float weight) {
        System.out.println("传入的age：" + age);
        System.out.println("传入的weight：" + weight);

        age = 33;
        weight = 89.3f;

        System.out.println("方法内重新赋值后的age：" + age);
        System.out.println("方法内重新赋值后的weight：" + weight);
    }

    // 值传递传递的是真实内容的一个副本，对副本的操作不影响原内容，也就是形参怎么变化，不会影响实参对应的内容。
    public static void main(String[] args) {
        int a = 25;
        float w = 77.5f;
        valueCrossTest(a, w);
        System.out.println("方法执行后的age：" + a);
        System.out.println("方法执行后的weight：" + w);
    }
}
