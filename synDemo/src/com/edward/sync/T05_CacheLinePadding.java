package com.edward.sync;

public class T05_CacheLinePadding {
    public static volatile  long [] arr = new long[16];

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000000000L; i++) {
                arr[0] = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000000000L; i++) {
                arr[8] = i;
            }
        });

        final long startTime = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime()-startTime)/1000000);
    }
}
