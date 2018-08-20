package com.hks.eightsortingalgorithms.aceessControler;

import java.io.IOException;

/**
 * 第二步：实现一个简单的类，主要用来测试我们自己定义的安全管理器起作用了没有，
 * 我们这里借助了FileInputStream，因为FileInputStream会调用安全管理器去校验权限
 * 所以用FileInputStream测试我们自己的安全管理器非常的适合。
 */
public class TestMySecurityManager {

    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        try {
            //FileInputStream fis = new FileInputStream("test");
            MyFileInputStream myFileInputStream = new MyFileInputStream("test");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
