package com.edward.threadpool;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"running");

    }
}
