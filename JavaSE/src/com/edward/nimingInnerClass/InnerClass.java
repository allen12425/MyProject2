package com.edward.nimingInnerClass;

public class InnerClass {
    public static void main(String[] args) {
        ChouXiang chouXiang = new ChouXiang() {
            String name = "Geek Song too";
            @Override
            public void say3() {
                System.out.println("这是匿名内部类当中的方法，重写了抽象类的方法");
                System.out.println(name);
            }
        };
    }
}
