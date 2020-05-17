package com.edward.innerclass;

public class InnerClass {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        a.say1();
        b.say2();
    }
}
