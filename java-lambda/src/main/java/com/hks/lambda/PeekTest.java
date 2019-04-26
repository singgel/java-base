package com.hks.lambda;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekTest {



    /**
     * forEach 是 terminal 操作，因此它执行后，Stream 的元素就被“消费”掉了，你无法对一个 Stream 进行两次 terminal 运算。
     *
     * 相反，具有相似功能的 intermediate 操作 peek 可以达到上述目的。
     */
    @Test
    public void foreachPeekTest(){
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

}
