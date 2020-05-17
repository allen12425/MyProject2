package com.edward.Thread;

public class Test_wait_notify {
    public static void main(String[] args) {
        final Object o = new Object();
        char[] arrI = "123456".toCharArray();
        char[] arrC = "ABCDEF".toCharArray();
        new Thread(() -> {
            synchronized (o) {
                for (char c : arrI) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();//让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//必须，否则无法停止程序
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : arrC) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//必须，否则无法停止程序
            }
        }, "t2").start();
    }
}
