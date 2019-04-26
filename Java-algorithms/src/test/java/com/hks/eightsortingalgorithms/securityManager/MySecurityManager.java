package com.hks.eightsortingalgorithms.securityManager;

/**
 * 第一步，定义一个类继承自SecurityManger重写它的checkRead方(如果你有兴趣可以先跳到super.checkRead(file, context);
 *
 */
public class MySecurityManager extends SecurityManager{

    @Override
    public void checkRead(String file) {
        //super.checkRead(file, context);
        if (file.endsWith("test"))
            throw new SecurityException("你没有读取的本文件的权限");
    }

}
