package com.edward.Thread.d_008;

import java.util.concurrent.TimeUnit;

public class Test {
    static volatile boolean running = true;
    public void m(){
        System.out.println("start");
        while (running) {
            //do somethind
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        Test t = new Test();

        new Thread(t::m,"t1").start();
        //new Thread(() -> {t.m();},"t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test.running = false;
    }
}
