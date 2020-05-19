package com.edward.proxy;

public class ThreadApiDemo {
    public static void main(String[] args) {
        //获取当前线程对象
        Thread thread = Thread.currentThread();
        //获取当前线程的名称
        System.out.println(thread.getName());
        //获取线程的id
        System.out.println(thread.getId());
        //获取线程的优先级
        System.out.println(thread.getPriority());
    }
}
