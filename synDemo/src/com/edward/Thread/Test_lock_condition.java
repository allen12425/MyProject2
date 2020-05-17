package com.edward.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_lock_condition {
    public static void main(String[] args) {
        char[] arrI = "123456".toCharArray();
        char[] arrC = "ABCDEF".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : arrI) {
                    System.out.print(c);
                    condition2.signal();//叫醒
                    condition1.await();//阻塞
                }
                condition2.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : arrC) {
                    System.out.print(c);
                    condition1.signal();//叫醒
                    condition2.await();//阻塞
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t2").start();
    }
}
