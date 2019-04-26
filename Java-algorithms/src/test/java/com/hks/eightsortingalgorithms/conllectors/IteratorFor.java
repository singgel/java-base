package com.hks.eightsortingalgorithms.conllectors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorFor {

    public static void main(String[] args) {
        /**
         * 不要在 foreach 循环里进行元素的 remove / add 操作。
         * remove 元素请使用 Iterator方式,
         * 如果并发操作,需要对 Iterator 对象加锁
         */
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        try {
            for (String temp : a) {
                if ("2".equals(temp)) {
                    a.remove(temp);
                }
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage() + "\n");
        }

        /**
         * 正例稳定正确地运行
         */
        Iterator it = a.iterator();
        while (it.hasNext()) {
            String temp = it.next().toString();
            System.out.print(temp + "\n");
            if ("2".equals(temp)) {
                it.remove();
            }
        }
    }

}
