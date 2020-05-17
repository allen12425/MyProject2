package com.edward.Thread.d_005;

import java.util.concurrent.TimeUnit;

public class T {
    public synchronized void m() {
        System.out.println("start m");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end m");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

    class TT extends T{
        public synchronized void m(){
            System.out.println("child m start");
            super.m();
            System.out.println("child m end");
        }
    }
