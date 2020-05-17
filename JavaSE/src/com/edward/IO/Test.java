package com.edward.IO;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }

    //1.文件字节输出流
    static void test1() {
        try {
            FileOutputStream out = new FileOutputStream("d:\\aaa.txt");
            String str = "hello world!";
            try {
                out.write(str.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.文件字节输入流
    static void test2() {
        try {
            FileInputStream in = new FileInputStream("d:\\aaa.txt");
            int a = 0;
            try {
                while ((a = in.read()) != -1) {
                    System.out.print((char) a);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //3.文件字符输出流
    static void test3() {
        try {
            FileWriter fw = new FileWriter("d:\\test.txt");
            String str = "极客在线教育";
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3.文件字符输入流
    static void test4() {
        try {
            FileReader in = new FileReader("d:\\test.txt");
            int index;
            while ((index = in.read()) != -1) {
                System.out.print((char) index);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
