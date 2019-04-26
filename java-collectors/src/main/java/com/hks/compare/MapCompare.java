package com.hks.compare;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/24
 */
public class MapCompare {

    /**
     * 按Key进行排序
     *
     * TreeMap<K,V>既可满足此类需求，向其构造方法 TreeMap(Comparator<? super K> comparator)
     * 传入我们自定义的比较器即可实现按键排序。
     */
    @Test
    public void TestSort1(){
        Map<String, String> resultMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });
        resultMap.put("1", "kfc");
        resultMap.put("4", "cba");
        resultMap.put("2", "wnba");
        resultMap.put("3", "nba");
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 按Value进行排序
     *
     * 将待排序Map中的所有元素置于一个列表中，接着使用Collections的一个静态方法 sort(List<T> list, Comparator<? super T> c) 
     * 来排序列表，同样是用比较器定义比较规则。
     * 排序后的列表中的元素再依次装入Map，为了肯定的保证Map中元素与排序后的List中的元素的顺序一致，使用了LinkedHashMap数据类型。
     */
    @Test
    public void TestSort2(){
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("kfc", "1");
        resultMap.put("wnba", "2");
        resultMap.put("nba", "6");
        resultMap.put("cba", "4");
        resultMap.put("eba", "5");
        resultMap.put("ebe", "0");
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
                resultMap.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }

        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 三种排序
     * 1.升序排列
     * 2.降序排序
     * 3.随机排序
     */
    @Test
    public void TestSort3() {
        //默认的TreeMap升序排列
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>();

        //降序排序
        TreeMap<Integer, Integer> map2 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            /*
             * int compare(Object o1, Object o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });

        //随机排序
        TreeMap<Integer, Integer> map3 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            /*
             * int compare(Object o1, Object o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(Integer a, Integer b) {
                int randomOne = (int) (Math.random() * 10);
                int randomTwo = (int) (Math.random() * 10);
                return randomOne - randomTwo;
            }
        });

        map2.put(1, 2);
        map2.put(2, 4);
        map2.put(2, 4);
        map2.put(7, 1);
        map2.put(5, 2);
        System.out.println("Map2降序排列=" + map2);

        map1.put(1, 2);
        map1.put(2, 4);
        map1.put(7, 1);
        map1.put(5, 2);
        map1.put(5, 2);
        System.out.println("map1升序排序=" + map1);

        map3.put(1, 2);
        map3.put(2, 4);
        map3.put(7, 1);
        map3.put(5, 2);
        map3.put(9, 2);
        map3.put(11, 2);
        map3.put(11, 2);
        System.out.println("map3随机排序=" + map3);
    }

    /**
     * Map转List 随机排序
     * @throws IOException
     */
    @Test
    public void TestSort4() throws IOException {
        Map<String, Object> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        List<String> list = new LinkedList(unsortMap.keySet());
        //随机排序
        Collections.shuffle(list);
        Map<String,Object> result = new HashMap<String,Object>();
        for (int i = 0; i < list.size(); i++) {
            String jsonString = list.get(i);
            result.put(jsonString, unsortMap.get(jsonString));
        }
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
