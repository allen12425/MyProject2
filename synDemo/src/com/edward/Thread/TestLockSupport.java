package com.edward.Thread;

import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {
    static Thread t1 = null, t2 = null;
    public static void main(String[] args) throws Exception{
        char[] arrI = "123456".toCharArray();
        char[] arrC = "ABCDEF".toCharArray();

        t1= new Thread(() -> {
            for (char c:arrI){
                System.out.print(c);
                LockSupport.unpark(t2);//叫醒t2
                LockSupport.park(t1);//阻塞t1
            }
        },"t1");
        t2= new Thread(() -> {
            for (char c:arrC){
                LockSupport.park(t2);//阻塞t2
                System.out.print(c);
                LockSupport.unpark(t1);//叫醒t1
            }
        },"t1");

        t1.start();
        t2.start();
    }
}
