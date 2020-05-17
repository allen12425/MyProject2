package com.edward.thread;

public class Test2 {
    public static void main(String[] args) {
        new Thread(() -> loop()).start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("end........");
    }

    static void loop() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
