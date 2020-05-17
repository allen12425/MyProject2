package com.edward.iterface;

public interface USB {
    /**
     * 接口中只有方法的定义，而没有方法的实现
     * 接口就像一个管理者，只告诉你做什么，而不管怎么做
     * 接口中的属性默认是 public static final的，也只能是这样
     * 接口中的方法默认是public abstract的，也只能是这样
     */
    void read();
    void write();
    public static void test(){
        
    }
}
