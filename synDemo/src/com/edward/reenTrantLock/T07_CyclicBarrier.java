package com.edward.reenTrantLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 满20个线程后就开始执行run
 * CyclicBarrier循环栅栏,满了指定的线程数栅栏就会放开执行
 */
public class T07_CyclicBarrier {
    public static void main(String[] args) {
        /*CyclicBarrier barrier = new CyclicBarrier(20);*/
        CyclicBarrier barrier = new CyclicBarrier(20,()->{
            System.out.println("满人，发车");
        });

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
