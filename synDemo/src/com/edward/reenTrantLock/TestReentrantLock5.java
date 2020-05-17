package com.edward.reenTrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock5 extends Thread{
    /**
     * sync是非公平锁
     * 公平锁是当一个线程获得锁执行的时候另一个线程会在线程等待队列排队，先来后到原则，等当前线程释放锁后
     * 排队的第一个线程获得锁，而非公平锁会直接与其他线程进行竞争而不去排队
     *
     */

    private static ReentrantLock lock = new ReentrantLock(true);//参数为true表示为公平锁,默认是非公平的
    public void run(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
            lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestReentrantLock5 t = new TestReentrantLock5();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }

}
