package com.edward.volatile_pak;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile不能保证原子性，不能让多线程同步执行
 */
public class Test2 {
    volatile int count = 0;
    /*synchronized*/ void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }
        threads.forEach(o -> o.start());
        threads.forEach(o->{
            try {
                o.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
