package com.edward.Thread.d_002;

public class Test implements Runnable{
    private int count = 100;//加了synchronized后就不用加volatile

    @Override
    public void run() {
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName() + " count=" + count);
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        for (int i = 0; i <100 ; i++) {
            new Thread(t,"Thread"+i).start();
        }
    }
}
