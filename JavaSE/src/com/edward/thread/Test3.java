package com.edward.thread;

public class Test3 {
    public static void main(String[] args) {
/*  Thread t = new MyThread();
    t.start();*/

        Thread t2 = new Thread(new MyThread2());
        t2.start();

        Runnable r = new MyThread2();
        Thread t3 = new Thread(r);
        t3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * 实现Runnable接口的优势：
 * 1、可以避免由于Java的单继承特性而带来的局限；
 *
 * 2、增强程序的健壮性，代码能够被多个线程共享，代码与数据是独立的；
 *
 * 3、适合多个相同程序代码的线程区处理同一资源的情况。
 */
class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
