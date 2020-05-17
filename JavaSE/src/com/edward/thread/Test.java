package com.edward.thread;

public class Test extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+"hello!");
    }


    public static void main(String[] args) {
        Thread r = new Test();
        r.start();
    }
}
