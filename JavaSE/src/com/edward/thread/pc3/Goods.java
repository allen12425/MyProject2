package com.edward.thread.pc3;

public class Goods {
    private String brand;
    private String name;
    //默认不存在商品，如果true,表示有商品
    private boolean flag = false;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //消费者获取商品
    public synchronized void get() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了" + this.getBrand() + "-----" + this.getName());
        flag = false;
        notify();
    }

    //生产者生产商品
    public synchronized void set(String brand, String name) {
        //当生产者抢占到cpu资源之后会判断当前对象是否有值，如果有值的话以为消费者还没有消费，需要提醒消费者消费，同时
        //当前线程进入阻塞状态，等待消费者取走商品之后再次生产；如果没有值，不需要等待进入阻塞，直接生产即可
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand() + "-------" + this.getName());
        //如果代码执行到此处，意味着生产完成，需要将flag设置为true
        flag = true;
        //唤醒消费者去进行消费
        notify();
    }
}
