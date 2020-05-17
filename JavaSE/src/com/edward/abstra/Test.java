package com.edward.abstra;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class Test {
    public static void main(String[] args) {
        Student stu = null;
        sum(stu);
        Dog dog = new Dog();
        dog.run();
        Cat cat = new Cat();
        cat.run();
    }

    public static void sum(@NotNull Student stu) {
        int sum = 0;
        for (int i = 1; i <= stu.getAge(); i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}


class Dog extends abstractClass {
    @Override
    public void test() {
        super.test();
    }

    @Override
    public void run() {
        System.out.println("Dog run ....");
    }
}

class Cat extends abstractClass {
    @Override
    public void test() {
        super.test();
    }

    @Override
    public void run() {
        System.out.println("Cat run...");
    }
}
