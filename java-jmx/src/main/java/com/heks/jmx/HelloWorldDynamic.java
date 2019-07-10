package com.heks.jmx;

import javax.management.*;
import javax.management.DynamicMBean;
import java.lang.reflect.Method;

public class HelloWorldDynamic implements DynamicMBean {
    public String hello;

    public HelloWorldDynamic() {
        this.hello = "Hello World! I am a Dynamic MBean";
    }

    public HelloWorldDynamic(String hello) {
        this.hello = hello;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Object getInstance() {
        return new Object();
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if ("getInstance".equals(attribute)) {
            return getInstance();
        }
        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {

    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        return null;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return null;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        return null;
    }

    MBeanInfo info = null;

    @Override
    public MBeanInfo getMBeanInfo() {
        try {
            Class cls = this.getClass();
            Method readMethod = cls.getMethod("getHello", new Class[0]);
            MBeanAttributeInfo attributeInfo = new MBeanAttributeInfo("gh", "the first attribute", readMethod, null);
            MBeanOperationInfo operationInfo = new MBeanOperationInfo("the first operation", cls.getMethod("getInstance",null));
            info = new MBeanInfo(cls.getName(),"this is a dynamic MBean",
                    new MBeanAttributeInfo[]{attributeInfo},null,
                    new MBeanOperationInfo[]{operationInfo},null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return info;
    }
}
