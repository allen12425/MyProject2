package com.edward.thread;

public class JoinTest {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread t = new Thread(myRun);
        t.start();


        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "------" + i);
            if (i == 3) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
