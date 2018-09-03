package com.hks.eightsortingalgorithms.cloneClass;

import org.junit.Test;

/**
 * 引用拷贝
 *
 * 可以看到，打印的结果是一样的，
 * 也就是说，二者的引用是同一个对象，并没有创建出一个新的对象
 */
public class ReferenceCopy {

    @Test
    public void copyReferenceObject(){
        Person p = new Person(23, "zhang");
        Person p1 = p;
        System.out.println(p);
        System.out.println(p1);
    }
}
