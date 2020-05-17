package com.edward.superdemo;

public class SuperClass {
    int i;
    public SuperClass(int i)
    {
        this.i = i;
        System.out.println("SuperClass... iiii");
    }
    public SuperClass() {
        System.out.println("SuperClass...");
    }
    public void display (){
        System.out.println("SuperClass i="+i);
    }
}
