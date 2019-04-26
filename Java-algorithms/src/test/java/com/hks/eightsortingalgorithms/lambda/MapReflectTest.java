package com.hks.eightsortingalgorithms.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReflectTest {

    /**
     * map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。
     */
    @Test
    public void oneToOneTest(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());

        squareNums.forEach(System.out::println);
    }

    /**
     * 还有一些场景，是一对多映射关系的，这时需要 flatMap。
     */
    @Test
    public void oneToManyTest(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

        outputStream.forEach(System.out::println);
    }

}
