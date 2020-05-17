package com.edward.lishidaihuan;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Person p = new Person();
        /**
         * 里氏代换，本质也是向上类型转换
         */
        p.care(cat);
        p.care(dog);

    }
}

interface Pet {
    void run();
}

class Cat implements Pet {
    @Override
    public void run() {
        System.out.println("Cat ....");
    }
}

class Dog implements Pet {
    @Override
    public void run() {
        System.out.println("Dog ....");
    }
}

class Person {
    void care(Pet p) {
        p.run();
    }

}


