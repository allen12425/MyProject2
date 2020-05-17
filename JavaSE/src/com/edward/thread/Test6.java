package com.edward.thread;

public class Test6 {
    public static void main(String[] args) {
        Runnable r = new MyThread6();
        Thread t = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        t.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t.start();
        t2.start();
    }
}

class MyThread6 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " i" + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 10 == 0) {
                //让出cpu让其他线程执行
                Thread.yield();
            }
        }
    }
}
