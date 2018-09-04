package com.hks.eightsortingalgorithms.annotation;

public class MyTest {

    @MyAnnotation(hello = "Hello,Beijing",world = "Hello,world")
    public void output() {
        System.out.println("method output is running ");
    }

}
