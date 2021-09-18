package com.hks.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkipTest {

    @Test
    public void testLimitAndSkip() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }

    /**
     * 有一种情况是 limit/skip 无法达到 short-circuiting 目的的，
     * 就是把它们放在 Stream 的排序操作后，原因跟 sorted 这个 intermediate 操作有关：
     * 此时系统并不知道 Stream 排序后的次序如何，所以 sorted 中的操作看上去就像完全没有被 limit 或者 skip 一样。
     *
     * 对 Stream 的排序通过 sorted 进行，
     * 它比数组的排序更强之处在于你可以首先对 Stream 进行各类 map、filter、limit、skip 甚至 distinct 来减少元素数量后，再排序，
     * 这能帮助程序明显缩短执行时间。
     */
    @Test
    public void testSort(){
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        //List<Person> personList2 = persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2).collect(Collectors.toList());
        List<Person> personList2 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        System.out.println(personList2);
    }

    private class Person {
        public int no;
        private String name;
        public Person (int no, String name) {
            this.no = no;
            this.name = name;
        }
        public String getName() {
            System.out.println(name);
            return name;
        }
    }
}
