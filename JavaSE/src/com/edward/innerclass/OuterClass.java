package com.edward.innerclass;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class OuterClass {
    private static final String NAME = "JACK";
    private int age = 34;

    public static void main(String[] args) {
        System.out.println();
    }
    //嵌套关系
    class InnerClass {
        int pid = 2;
        public void test() {
            System.out.println(age);
            System.out.println(NAME);
        }
    }

    //静态内部类
    static class StaticInnerClass {

    }

    static void test() {
        class LoadClass {//局部内部类

        }
    }
}

class B {

}
