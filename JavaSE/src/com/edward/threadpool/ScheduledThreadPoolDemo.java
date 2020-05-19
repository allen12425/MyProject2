package com.edward.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒");
                System.out.println(System.currentTimeMillis());
            }
        },3, TimeUnit.SECONDS);


        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒，每三秒执行一次");
                System.out.println(System.currentTimeMillis());
            }
        },1,3, TimeUnit.SECONDS);
    }
}
