package com.heks.stream;

/**
 * @author heks
 * @description: TODO
 * @date 2020/11/11
 */

import java.util.Iterator;
import java.util.List;

/**
 * 集合流生成器
 */
public class CollectionStreamGenerator {
    /**
     * 将一个List转化为stream流
     * */
    public static <T> MyStream<T> getListStream(List<T> list){
        return getListStream(list.iterator(),true);
    }

    /**
     * 递归函数
     * @param iterator list 集合的迭代器
     * @param isStart 是否是第一次迭代
     * */
    private static <T> MyStream<T> getListStream(Iterator<T> iterator, boolean isStart){
        if(!iterator.hasNext()){
            // 不存在迭代的下一个元素，返回空的流
            return Stream.makeEmptyStream();
        }

        if(isStart){
            // 初始化，只需要设置 求值过程
            return new MyStream.Builder<T>()
                    .nextItemEvalProcess(new NextItemEvalProcess(()-> getListStream(iterator,false)))
                    .build();
        }else{
            // 非初始化，设置head和接下来的求值过程
            return new MyStream.Builder<T>()
                    .head(iterator.next())
                    .nextItemEvalProcess(new NextItemEvalProcess(()-> getListStream(iterator,false)))
                    .build();
        }
    }
}
