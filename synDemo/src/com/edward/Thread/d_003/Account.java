package com.edward.Thread.d_003;

import java.util.concurrent.TimeUnit;

public class Account {
    private String name;
    private double balance;

    public synchronized void setBalance(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(()->{
            account.setBalance("zhangsan", 100.00);}).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("张三"));
    }
}
