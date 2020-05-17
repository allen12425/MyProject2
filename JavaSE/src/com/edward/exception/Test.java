package com.edward.exception;

public class Test {
    public static void main(String[] args) {
        Person p = new Person(89);

        try {
            p.run();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
