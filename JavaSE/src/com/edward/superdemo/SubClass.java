package com.edward.superdemo;

public class SubClass extends SuperClass {
    int i = 10;
    public SubClass() {
        super();
        System.out.println("SubClass...");
    }
    public SubClass(int i){
        super(i);
        System.out.println("SubClass....iiii");
    }
    public void display(){
        super.display();
        System.out.println("SubClass  i="+i);
        System.out.println("SuperClass i="+super.i);
    }
    public void test(){
        this.display();
        super.display();
    }
}
