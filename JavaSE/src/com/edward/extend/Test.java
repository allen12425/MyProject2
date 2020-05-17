package com.edward.extend;

class Father {
    public void func1() {
        func2();
    }

    public void func2() {
        System.out.println("AAA");
    }
}

class Child extends Father {
    public void func1(int i) {
        System.out.println("BBB");
    }

    public void test() {
        System.out.println("test");
    }

    public void func2() {
        System.out.println("CCC");
    }
}

public class Test {
    public static void main(String[] args) {
        /**
         * 父类对象引用指向子类对象
         * 也叫向上转型，体现了java的多态性
         * 缺点是会遗失子类有的父类没有的方法
         *
         */
        Father f = new Child();
        //子类和父类都有的方法，则运行该子类的方法；
        f.func1();
        /**
         * 向下转型,向下类型转换是基于向上类型转换的
         */
        Child c = (Child) f;
        c.func1();
        c.func1(1);
        c.func2();
        c.test();
    }

}
