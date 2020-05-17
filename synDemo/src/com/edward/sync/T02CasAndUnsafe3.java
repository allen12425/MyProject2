package com.edward.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;


/**
 * CAS(compare swap)又叫自旋锁 （底层是 lock compare & change 指令）
 */
public class T02CasAndUnsafe3 {
    private static int m = 0;
    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        Object obj = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (obj) {
                    for (int j = 0; j < 1000; j++) {
                        m++;
                    }
                    latch.countDown();
                }
            });
        }
        Arrays.stream(threads).forEach(t->t.start());
        latch.await();
        System.out.println(m);
    }
}
