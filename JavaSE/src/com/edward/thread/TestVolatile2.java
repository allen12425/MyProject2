package com.edward.thread;

import java.util.concurrent.TimeUnit;

public class TestVolatile2 {
    /*volatile */static boolean running = true;

    void m() {
        System.out.println("Start");
        while (running) {

        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        TestVolatile2 t = new TestVolatile2();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
