package com.edward.Thread.d_004;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 是支持锁重入的，都是同一把锁
 */
public class T {
    public synchronized void m1() {
        System.out.println("start m1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("end m2");
    }

    public synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        new T().m1();
    }
}
