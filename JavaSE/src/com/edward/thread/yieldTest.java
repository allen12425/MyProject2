package com.edward.thread;

public class yieldTest {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun);
        thread.start();

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + "=======" + i + "礼让一次");
            }else{
                System.out.println(Thread.currentThread().getName()+"====="+i);
            }
        }
    }
}
