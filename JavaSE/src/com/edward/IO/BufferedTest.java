package com.edward.IO;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        //test1();
        //test3();
        test2();
        //test4();
    }

    //1.缓冲字节输出流
    static void test1() {
        try {
            OutputStream out = new FileOutputStream("d:\\test.txt");
            BufferedOutputStream bos = new BufferedOutputStream(out);
            String str = "aaa";
            try {
                bos.flush();
                bos.write(str.getBytes());
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.缓冲字节输入流
    static void test2() {
        try {
            InputStream in = new FileInputStream("d:\\test.txt");
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] b = new byte[in.available()];//小文件可以这么写
            bis.read(b);
            bis.close();
            in.close();
            System.out.println(new String(b));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.缓冲字符输出流
    static void test3() {
        try {
            Writer w = new FileWriter("d:\\aaa.txt");
            BufferedWriter bw = new BufferedWriter(w);
            String str = "欢迎光临";
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4.缓冲字符输入流
    static void test4() {
        try {
            Reader r = new FileReader("d:\\aaa.txt");
            BufferedReader br = new BufferedReader(r);
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
