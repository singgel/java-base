package com.hks.eightsortingalgorithms.Proxy.cglib;

import com.hks.eightsortingalgorithms.Proxy.UserService;
import com.hks.eightsortingalgorithms.Proxy.UserServiceImpl;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

    public static void main(String[] args) {
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(myMethodInterceptor);

        UserService o = (UserService)enhancer.create();
        o.getName(1);
        o.getAge(1);
    }

}
