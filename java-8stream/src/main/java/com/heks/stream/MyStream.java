package com.heks.stream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @author heks
 * @description: https://www.cnblogs.com/xiaoxiongcanguan/p/10511233.html
 *
 * 5.1 当前版本缺陷
 * 1. 递归调用效率较低
 *
 * 　　为了代码的简洁性和更加的函数式，当前实现中很多地方都用递归代替了循环迭代。
 *
 * 　　虽然逻辑上递归和迭代是等价的，但在目前的计算机硬件上，每一层的递归调用都会使得函数调用栈增大，而即使是明显的尾递归调用，java目前也没有能力进行优化。当流需要处理的数据量很大时，将会出现栈溢出，栈空间不足之类的系统错误。
 *
 * 　　将递归优化为迭代能够显著提高当前版本流的执行效率。
 *
 * 2. API接口较少
 *
 * 　　限于篇幅，我们只提供了一些较为常用的API接口。在jdk中，Collector工具类提供了很多方便易用的接口；对于同一API接口也提供了多种重载函数给用户使用。
 *
 * 　　以目前已有的功能为基础，提供一些更加方便的接口并不困难。
 *
 * 3. 不支持并行计算
 *
 * 　　由于流在求值计算时生成的是对象的副本，是无副作用的，很适合通过数据分片执行并行计算。限于个人水平，在设计之初并没有考虑将并行计算这一特性加入进来。
 * @date 2020/11/11
 */
public class MyStream<T> implements com.heks.stream.Stream<T> {
    /**
     * 流的头部
     * */
    private T head;

    /**
     * 流的下一项求值函数
     * */
    private NextItemEvalProcess nextItemEvalProcess;

    /**
     * 是否是流的结尾
     * */
    private boolean isEnd;

    @Override
    public <R> MyStream<R> map(Function<R, T> mapper) {
        NextItemEvalProcess lastNextItemEvalProcess = this.nextItemEvalProcess;
        this.nextItemEvalProcess = new NextItemEvalProcess(
                ()->{
                    MyStream myStream = lastNextItemEvalProcess.eval();
                    return map(mapper, myStream);
                }
        );

        // 求值链条 加入一个新的process map
        return new MyStream.Builder<R>()
                .nextItemEvalProcess(this.nextItemEvalProcess)
                .build();
    }
    /**
     * 递归函数 配合API.map
     * */
    private static <R,T> MyStream<R> map(Function<R, T> mapper, MyStream<R> myStream){
        if(myStream.isEmptyStream()){
            return Stream.makeEmptyStream();
        }

        T head = mapper.apply(myStream.head);

        return new MyStream.Builder<R>()
                .head((R) head)
                .nextItemEvalProcess(new NextItemEvalProcess(()->map(mapper, myStream.eval())))
                .build();
    }

    @Override
    public <R> MyStream<R> flatMap(Function<? extends MyStream<R>, T> mapper) {
        return null;
    }

    @Override
    public MyStream<T> filter(Predicate<T> predicate) {
        return null;
    }

    @Override
    public MyStream<T> limit(int n) {
        return null;
    }

    @Override
    public MyStream<T> distinct() {
        return null;
    }

    @Override
    public MyStream<T> peek(ForEach<T> consumer) {
        return null;
    }

    @Override
    public void forEach(ForEach<T> consumer) {
        // 终结操作 直接开始求值
        forEach(consumer,this.eval());
    }

    /**
     * 递归函数 配合API.forEach
     * */
    private static <T> void forEach(ForEach<T> consumer, MyStream<T> myStream){
        if(myStream.isEmptyStream()){
            return;
        }

        consumer.apply(myStream.head);
        forEach(consumer, myStream.eval());
    }

    @Override
    public <R> R reduce(R initVal, BiFunction<R, R, T> accumulator) {
        return null;
    }

    @Override
    public <R, A> R collect(Collector<T, A, R> collector) {
        return null;
    }

    @Override
    public T max(Comparator<T> comparator) {
        return null;
    }

    @Override
    public T min(Comparator<T> comparator) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return false;
    }

    public static class Builder<T>{
        private MyStream<T> target;

        public Builder() {
            this.target = new MyStream<>();
        }

        public Builder<T> head(T head){
            target.head = head;
            return this;
        }

        Builder<T> isEnd(boolean isEnd){
            target.isEnd = isEnd;
            return this;
        }

        public Builder<T> nextItemEvalProcess(NextItemEvalProcess nextItemEvalProcess){
            target.nextItemEvalProcess = nextItemEvalProcess;
            return this;
        }

        public MyStream<T> build(){
            return target;
        }
    }

    /**
     * 当前流强制求值
     * @return 求值之后返回一个新的流
     * */
    private MyStream<T> eval(){
        return this.nextItemEvalProcess.eval();
    }

    /**
     * 当前流 为空
     * */
    private boolean isEmptyStream(){
        return this.isEnd;
    }
}
