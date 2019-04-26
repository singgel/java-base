package com.hks.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * <? extends T>是上界通配符。逻辑上来说，一个可以往里面放动物的容器，也可以往里面放狗，因为狗是继承了动物的，
 * 所以从逻辑上来说，一个可以放狗的容器也应该是继承一个可以放动物的容器的。
 *
 * 但是Java中这是不对的。这时候就需要上界通配符来解决这个问题。
 * @param <T>
 */
public class Content<T> {

    private String contentName;
    private List<T> content;
    private T t;
    private int size;
    public Content(){
        content = new ArrayList<T>();
        size = 0;
    }
    public String getContentName() {
        return contentName;
    }
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public List<T> getContent() {
        return content;
    }
    @SuppressWarnings("unchecked")
    public void setContent(List<? super T> content) {
        this.content = (List<T>) content;
    }

    public void add(T content){
        this.content.add(content);
    }

    public void getInfo(){
        System.out.println(content.toString());
    }
    public int getSize(){
        size = content.size();
        return size;
    }
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }

    public void remove(int pos){
        this.content.remove(pos);
    }

    public T get(int i){
        if(i>content.size())
            return null;
        return content.get(i);
    }
}
