package com.edward.reenTrantLock;

import java.util.concurrent.CountDownLatch;

public class Test06_CountDownLatch {
    public static void main(String[] args) {
        usingCountDownLatch();
        usingJoin();
    }

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 100; j++) {
                    result += j;
                }
                latch.countDown();  //线程每执行一次门栓减一
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        try {
            latch.await();//等每个线程执行完后打开栓，继续往下走
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");
    }

    private static void usingJoin() {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 100; j++) {
                    result += j;
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end join");
    }
}
