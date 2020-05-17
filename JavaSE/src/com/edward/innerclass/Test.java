package com.edward.innerclass;

public class Test {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass innerClass = oc.new InnerClass();
        OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();

        USB u = new USB() {
            @Override
            public void read() {

            }

            @Override
            public void write() {

            }
        };

        Animal a = new Animal() {
            @Override
            void run() {

            }
        };
    }
}

abstract class Animal {
    abstract void run();
}

interface USB {
    void read();

    void write();

}

