package com.edward.reenTrantLock;

import java.util.concurrent.Semaphore;

/**
 * Semaphore用来做限流
 */
public class T11_TestSemaphore {
    public static void main(String[] args) {
        //Semaphore s = new Semaphore(1);
        Semaphore s = new Semaphore(2,true);//同时允许两个线程同时执行，后面的线程公平排队
        //只允许一个线程同时执行

        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }

        }).start();

        new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
