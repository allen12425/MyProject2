package com.edward.callable;

import java.util.concurrent.*;

public class Test3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Integer> callable = new MyTask();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        executor.submit(futureTask);
        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}

class MyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum=0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;
    }
}
