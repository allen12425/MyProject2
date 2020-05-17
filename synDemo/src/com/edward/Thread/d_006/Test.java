package com.edward.Thread.d_006;

import java.util.concurrent.TimeUnit;

/**
 * 程序中如果出现异常，默认情况下锁会被释,因此会导致数据不一致问题
 */
public class Test {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count=" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;//此处会发生算术异常
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();
    }
}
