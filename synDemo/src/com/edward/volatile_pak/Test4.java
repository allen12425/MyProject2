package com.edward.volatile_pak;

import java.util.concurrent.TimeUnit;

/**
 * 锁定的对象的属性发生改变不会影响锁定
 * 如果变成了另一个对象，则锁定的对象发生改变
 * 应避免锁定的对象引用发生改变
 */
public class Test4 {

   final Object o = new Object();

    void m(){
        synchronized (o){
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Test4 test = new Test4();
        new Thread(test::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(test::m,"t2");
       // test.o = new Object();
        t2.start();
    }
}
