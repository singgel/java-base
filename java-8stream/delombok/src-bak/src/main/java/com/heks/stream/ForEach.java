package com.heks.stream;

/**
 * @author heks
 * @description: TODO
 * @date 2020/11/11
 */
@FunctionalInterface
public interface ForEach <T>{

    /**
     * 迭代器遍历
     * @param item 被迭代的每一项
     * */
    void apply(T item);
}
