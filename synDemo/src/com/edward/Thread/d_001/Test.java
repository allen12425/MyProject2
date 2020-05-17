package com.edward.Thread.d_001;

public class Test {
    private static int count = 10;
    private Object o = new Object();
    /**
     *如果synchronized加在一个类的普通方法上，那么相当于synchronized(this)。
     *如果synchronized加载一个类的静态方法上，那么相当于synchronized(Class对象)。
     * 使用class在执行到synchronized时会等待其他占用的线程执行玩才会继续执行
     * 使用this执行线程时只会考虑到同一个线程中的同步问题，严格来说是无法达到真正意义上的线程同步
     */

    /**
     * synchronized(object) 此处Object不能用String常量，Integer，Long
     */
    public void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

    public void m2() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

    public synchronized void m3() {//等同于synchronized (this)
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
    }



    public static void m4(){
        synchronized (Test.class){
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }


    public synchronized static void m5() {//这里等同于synchronized (Test.class)
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

}
