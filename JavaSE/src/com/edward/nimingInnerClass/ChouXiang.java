package com.edward.nimingInnerClass;

public abstract class ChouXiang {
    String name = "Geek Song";//抽象类的属性是不会被调用的，除了方法
    public void say3(){
        System.out.println("这是抽象类当中的方法，抽象类是允许有具体方法来进行实现的");
    }
}
