package com.heks.stream;

/**
 * @author heks
 * @description: TODO
 * @date 2020/11/11
 */
@FunctionalInterface
public interface EvalFunction<T> {

    /**
     * stream流的强制求值方法
     * @return 求值返回一个新的stream
     * */
    MyStream<T> apply();
}
