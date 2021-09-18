package com.hks.hashcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 其实equals 比较的也是 两个 对象是否为同一对象，也就是比较的reference
 */
public class EqualsTest {

    Person person1 = new Person();
    Person person2 = person1;

    Person person3 = new Person();

    @Test
    public void addrTest() {
        System.out.println(person1.equals(person2));
        person1.setAge(10);
        System.out.println(person2.getAge());
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));

        System.out.println("============");
        List<Person> personList = new LinkedList<>();
        personList.add(person1);
        Person person4 = person1;
        person4.setAge(90);
        personList.add(person4);
        for (Person person : personList) {
            System.out.println(person.toString() + person.getAge());
        }
        ///equals没被重写
        /*public boolean equals(Object obj) {
            return (this == obj);
        }*/
    }

    @Test
    public void intergerTest() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(2);
        Integer i3 = new Integer(1);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(i3));

        ///equals被重写
        /*public boolean equals(Object obj) {
            if (obj instanceof Integer) {
                return value == ((Integer)obj).intValue();
            }
            return false;
        }*/
    }

}
