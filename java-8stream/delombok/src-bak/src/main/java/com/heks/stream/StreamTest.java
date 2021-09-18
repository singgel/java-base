package com.heks.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author heks
 * @description: 两种方案的不同之处：
 *
 * 　　从函数式的角度上看，过程式的代码实现将收集元素、循环迭代、各种逻辑判断耦合在一起，暴露了太多细节。当未来需求变动和变得更加复杂的情况下，过程式的代码将变得难以理解和维护(需要控制台打印出 年龄为70岁的前10个Person中，姓王的Person的名称）。
 *
 * 　　函数式的解决方案解开了代码细节和业务逻辑的耦合，类似于sql语句，表达的是"要做什么"而不是"如何去做"，使程序员可以更加专注于业务逻辑，写出易于理解和维护的代码。
 *
 * @FunctionalInterface 这个注解很有意思了
 * @date 2020/11/11
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>(); // 获得List<Person>
        int limit = 10; // 限制条件
        List<String> nameList = new ArrayList(); // 收集的姓名集合
        for(Person personItem : personList){
            if(personItem.getAge() == 70){ // 满足条件
                nameList.add(personItem.getName()); // 加入姓名集合
                if(nameList.size() >= 10){ // 判断是否超过限制
                    break;
                }
            }
        }
        System.out.println(nameList);

        System.out.println("************************");

        List<String> aa = personList.stream()
                .filter(item->item.getAge() == 70)// 过滤条件
                .limit(10)// limit限制条件
                .map(item->item.getName())// 获得姓名
                .collect(Collectors.toList()); // 转化为list
    }
}
