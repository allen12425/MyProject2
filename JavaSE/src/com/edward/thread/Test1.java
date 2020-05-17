package com.edward.thread;

public class Test1 {
    public static void main(String[] args) {
        loop();
        System.out.println("end........");
    }

    static void loop() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
