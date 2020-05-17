package com.edward.abstra;

public class Test2 {
    public static void main(String[] args) {
        //抽象类不能直接实例化
        //Animal animal = new Animal();
        Chicken chicken = new Chicken();
        chicken.run();

    }
}

abstract class Animal {
    public abstract void run();
}

//1.实现抽象方法
class Chicken extends Animal {
    @Override
    public void run() {
        System.out.println("chicken run ...");
    }
}

//2.自己是抽象类
abstract class Pig extends Animal {

}
