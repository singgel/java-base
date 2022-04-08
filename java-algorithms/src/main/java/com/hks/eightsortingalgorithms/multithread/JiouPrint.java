package com.hks.eightsortingalgorithms.multithread;

import java.util.concurrent.Semaphore;

public class JiouPrint {
    Semaphore semaphore = new Semaphore(0);

    public void main(String[] args) {
        int i = 0;

    }

    class printJ implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 10; i = i + 2) {
                try {
                    semaphore.acquire();
                    System.out.println("=======" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class printO implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i = i + 2) {
                System.out.println("=======" + i);
                semaphore.release();
            }
        }
    }
}
