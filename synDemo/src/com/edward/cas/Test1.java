package com.edward.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 比较sync,atomic,longAdder的性能
 * 根据线程数的多少性能各不同
 */
public class Test1 {
    static long count2 = 0L;
    static AtomicInteger count1 = new AtomicInteger(0);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j <100000 ; j++) {
                    count1.incrementAndGet();
                }
            });
        }
        long start = System.currentTimeMillis();
        for (Thread thread:threads) thread.start();
        for (Thread thread:threads) thread.join();
        long end = System.currentTimeMillis();
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j <100000 ; j++) {
                    synchronized (/*Test1.class*/lock){
                        count2++;
                    }
                }
            });
        }
        long start2 = System.currentTimeMillis();
        for (Thread thread:threads)thread.start();
        for (Thread thread:threads)thread.join();
        long end2 = System.currentTimeMillis();


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j <100000 ; j++) {
                   count3.increment();
                }
            });
        }
        long start3 = System.currentTimeMillis();
        for (Thread thread:threads)thread.start();
        for (Thread thread:threads)thread.join();
        long end3 = System.currentTimeMillis();


        System.out.println("atomic:"+count1.get()+"time:"+(end-start));
        System.out.println("sync:"+count2+"time:"+(end2-start2));
        System.out.println("longadd:"+count3.longValue()+"time:"+(end3-start3));
    }
}
