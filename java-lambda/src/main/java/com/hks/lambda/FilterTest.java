package com.hks.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class FilterTest {

    /**
     * filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
     */
    @Test
    public void simpleFilterTest(){
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =
                Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);

        Arrays.stream(evens).forEach(System.out::println);
    }

}
