package com.hks.eightsortingalgorithms.securityManager;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 第二步，定义一个有main函数的public类来验证自己的安全管理器是不是器作用了。
 */
public class TestMySecurityManager {

    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        try {
            FileInputStream fis = new FileInputStream("test");
            System.out.println(fis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 第三步，运行代码查看控制台输出
     */


}
