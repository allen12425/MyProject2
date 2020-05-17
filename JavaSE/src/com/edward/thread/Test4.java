package com.edward.thread;

public class Test4 {
    public static void main(String[] args) {
        Thread t = new MyThread3();
        t.start();//启动线程
        new MyThread3().flag = false;
        System.out.println("end");
    }
}

//1.线程停止的方法，run方法返回return
//2.设置flag标志位
class MyThread3 extends Thread {
    /*static*/ boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while (flag) {
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            /*if (i == 5) {
                flag = false;
            }*/
        }

    }
}