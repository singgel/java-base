package com.hks.hashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap除了支持默认的插入顺序，还支持访问顺序。
 * 所谓访问顺序(access-order)是指在迭代遍历列表中的元素时最近访问的元素会排在LinkedHashMap的尾部
 *
 * 根据测试看输出
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<String, Object>(16, 0.75F, true);

        for (int i = 1; i <= 5; i++) {
            map.put(i + "", i);
        }
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }

        map.get("2");
        map.get("3");
        System.out.println("===============split line==================");

        Iterator<Map.Entry<String, Object>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().getValue());
        }
    }

}
