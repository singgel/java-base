package com.hks.btrace;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExpandCapacity {
    public static final int ONE_MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        mapExpandCapacity();
    }
    /**
     * java.util.HashMap#resize(int)
     * 何时扩容，发生扩容时候的上下文情况
     */
    public static void mapExpandCapacity() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //这是模拟主要逻辑
                    //16,0.75 16*0.75=12
                    Map<Integer, Byte[]> map = new HashMap<Integer, Byte[]>();
                    int size = 100;
                    for (int i = 0; i < size; i++) {
                        map.put(i, new Byte[ONE_MB]);
                    }
                    System.out.println("Expand SIZE = " + map.size());
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "mapExpandCapacity").start();
        TimeUnit.HOURS.sleep(1);
    }
}
