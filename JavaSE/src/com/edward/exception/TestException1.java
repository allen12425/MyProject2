package com.edward.exception;

import java.util.logging.Logger;

public class TestException1 {
    public static void main(String[] args) {
        //test1();
        test2();
        System.out.println("hello...");
    }

    public static void test1(){
        String str = null;
        try {
            System.out.println(str.length());
        } catch (Exception e) {
            throw new NullPointerException("空指针");
        }

    }
    public static void test2(){
        String str = null;
        try {
            System.out.println(str.length());
            System.out.println("jack");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
