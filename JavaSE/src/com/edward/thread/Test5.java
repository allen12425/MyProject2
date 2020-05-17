package com.edward.thread;

public class Test5 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread5(),"T1");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread5 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i=" + i);
            try {
                //sleep会使线程阻塞
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
