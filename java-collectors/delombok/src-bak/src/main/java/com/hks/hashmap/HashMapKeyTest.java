package com.hks.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeyTest {

    public static void main(String[] args) {
        Map<A, String> map = new HashMap<A, String>();
        A a1 = new A();
        a1.setCode("123");
        a1.setName("456");
        map.put(a1, "test1");
        System.out.println(map);
        a1.setCode("789");
        map.put(a1, "test2");
        System.out.println(map);
    }

}
