package com.edward.thread.pc4;

import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable {

    private BlockingQueue<Goods> blockingQueue;

    public ProducerQueue(BlockingQueue<Goods> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Goods goods = new Goods("哇哈哈", "矿泉水");
            System.out.println("生产者开始生产商品" + goods.getBrand() + "-----" + goods.getName());
            try {
                blockingQueue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
