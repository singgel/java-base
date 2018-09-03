package com.hks.eightsortingalgorithms.lambda;

import org.junit.Test;

import java.util.Optional;

/**
 * findFirst这是一个 termimal 兼 short-circuiting 操作，它总是返回 Stream 的第一个元素，或者空
 */
public class FindFirstTest {

    String strA = " abcd ", strB = null;

    /**
     * 这里比较重点的是它的返回值类型：Optional。
     * 这也是一个模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。
     * 使用它的目的是尽可能避免 NullPointerException。
     */
    @Test
    public void test(){
        print(strA);
        System.out.println("--");
        print("");
        System.out.println("--");
        print(strB);
        System.out.println("--");
        System.out.println(getLength(strA));
        System.out.println("--");
        System.out.println(getLength(""));
        System.out.println("--");
        System.out.println(getLength(strB));
    }

    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
        if (text != null) {
            System.out.println(text);
        }
    }

    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
// return if (text != null) ? text.length() : -1;
    };
}
