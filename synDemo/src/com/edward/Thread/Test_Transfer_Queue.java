package com.edward.Thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Test_Transfer_Queue {
    public static void main(String[] args) {
        char[] arrI = "123456".toCharArray();
        char[] arrC = "ABCDEF".toCharArray();

        //这种队列生产者和消费者必须同对出现
        TransferQueue<Character> queue = new LinkedTransferQueue<Character>();
        new Thread(() -> {
            for (char c : arrI) {
                try {
                    queue.transfer(c);  //放进去  这个方法是阻塞的
                    System.out.println(queue.take());//取出来
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(() -> {
            for (char c : arrC) {
                try {
                    System.out.println(queue.take());
                    queue.transfer(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
    }


}
