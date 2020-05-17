package com.edward.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    /*volatile int count = 0;*/
    AtomicInteger count = new AtomicInteger(0);

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();//count++;
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(test::m, "thread-" + i));
        }
        threads.forEach(e -> e.start());

        threads.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread().getName()+"-end");
    }

}
