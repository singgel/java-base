package com.heks.jmx;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class HelloWorld extends NotificationBroadcasterSupport implements HelloWorldMBean {
    public String hello;

    private long seq = 0L;

    public HelloWorld() {
        this.hello = "Hello World! I am a Standard MBean";
    }

    public HelloWorld(String hello) {
        this.hello = hello;
    }

    @Override
    public String getHello() {
        return hello;
    }

    @Override
    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public Object getInstance() {
        return new Object();
    }

    /**
     * 当执行message的时候，发送一个消息(事件)
     * @param msg
     * @return
     */
    @Override
    public String message(String msg) {
        Notification notice = new Notification("type1", this, seq++, " the message metheod is invoked,the argument ms: " + msg);
        sendNotification(notice);
        return "the message:" + msg;
    }
}
