package com.heks.jmx;

public interface HelloWorldMBean {

    String getHello();

    void setHello(String hello);

    Object getInstance();

    String message(String msg);
}
