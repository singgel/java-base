package com.hks.eightsortingalgorithms;

public class EqualsOOMTest {

    /**
        说明： 对于 Integer var=?
        在-128 至 127 之间的赋值， Integer 对象是在IntegerCache.cache 产生，会复用已有对象，
        这个区间内的 Integer 值可以直接使用==进行判断，

        但是这个区间之外的所有数据，
        都会在堆上产生，并不会复用已有对象
     */
    public static void main(String[] args){
        Integer i1 = 123;
        Integer i2 = 123;
        System.out.println(i1==i2);
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i3==i4);
        System.out.println(i3.equals(i4));
        int i5 = 130;
        int i6 = 130;
        System.out.println(i5==i6);
    }

}
