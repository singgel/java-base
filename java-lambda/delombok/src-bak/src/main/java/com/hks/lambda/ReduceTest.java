package com.hks.lambda;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），
 *
 * 和前面 Stream 的第一个、第二个、第 n 个元素组合。
 * 从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。
 */
public class ReduceTest {

    @Test
    public void reduceTest(){
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.print(concat+"\r\n");
// 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.print(minValue+"\r\n");
// 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.print(sumValue+"\r\n");
// 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.print(sumValue+"\r\n");
// 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.print(concat+"\r\n");
    }

}
