package com.heks.jmx;


import org.junit.Test;

import javax.management.*;
import java.util.Set;

public class StandardJMXTest {

    /**
     * 需要被管理的方法、属性等在接口中定义好，创建一个类，继承此接口，然后实现时候方法，
     * 这样，但注册到MBeanServer的时候，会自动管理其，接口中的各个属性、方法。
     */
    @Test
    public void test1StandardMBean() throws Exception {
        MBeanServer ms = MBeanServerFactory.createMBeanServer();
        ObjectName name = new ObjectName("Hello:type=myfirstMbean");
        HelloWorld helloWorld = new HelloWorld("heks");

        helloWorld.addNotificationListener(new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object handback) {
                System.out.println(" access listen : " + notification);
            }
        }, null, null);

        ms.registerMBean(helloWorld, name);

        String s1 = (String) ms.getAttribute(name, "Hello");
        System.out.println("the init value: " + s1);

        ms.setAttribute(name,new Attribute("Hello","hi heks"));
        String  s2 = (String)ms.getAttribute(name,"Hello");
        System.out.println("the init value: " + s2);

        ms.invoke(name,"message",new Object[]{"i as message"},new String[]{"java.lang.String"});
        ObjectName name2 = new ObjectName("*:*");
        Set<ObjectInstance> set = ms.queryMBeans(name2,null);
        System.out.println(set);
    }

}
