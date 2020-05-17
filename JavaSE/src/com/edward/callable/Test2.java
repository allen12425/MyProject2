package com.edward.callable;

import java.util.concurrent.*;

public class Test2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable callable = new Task();
        Future<Integer> result = executorService.submit(callable);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {   System.out.println("主线程在执行任务");
            System.out.println("task的运行结果为："+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;
    }
}