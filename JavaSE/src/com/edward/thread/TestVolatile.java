package com.edward.thread;

public class TestVolatile {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("start");
            while (flag) {

            }
            System.out.println("end");
        }, "server").start();
        Thread.sleep(1000);
        flag = false;
    }

}
