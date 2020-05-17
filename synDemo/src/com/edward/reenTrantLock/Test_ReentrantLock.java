package com.edward.reenTrantLock;

import java.util.concurrent.TimeUnit;

/**
 * 可冲入
 */
public class Test_ReentrantLock {
    public synchronized void m(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i==2){ m2();}
        }

    }

    public synchronized void m2(){
        System.out.println("m2...");
    }

    public static void main(String[] args) {
        Test_ReentrantLock t = new Test_ReentrantLock();
        new Thread(t::m).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m2).start();
    }
}
