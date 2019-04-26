package com.hks.valuePass;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/29
 * <p>
 * 引用传递：
 * ”引用”也就是指向真实内容的地址值，在方法调用时，
 * 实参的地址通过方法调用被传递给相应的形参，在方法体内，
 * 形参和实参指向相同的内存地址，对形参的操作会影响的真实内容。
 */
public class RefrencePassTest {

    public static void PersonCrossTest(Person person) {
        System.out.println("传入的person的name：" + person.getName());
        person.setName("我是张小龙");

        //加多此行代码
        ///无论是基本类型和是引用类型，在实参传入形参时，都是值传递，也就是说传递的都是一个副本，而不是内容本身。
        person = new Person();
        person.setName("啊哈");
        System.out.println("方法内重新赋值后的name：" + person.getName());
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("我是马化腾");
        p.setAge(45);
        PersonCrossTest(p);
        System.out.println("方法执行后的name：" + p.getName());
    }
}
