package com.edward.IO;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        test2();
    }
    //1.将字节输出流转换为字符输出流
    static void test1(){
        try{
            Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\aaa.txt")));
            w.write("我是中国人");
            w.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //2.将字节输入流转换为字符输入流
    static void test2(){
        System.out.println("输入byte退出程序");
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String str = br.readLine();
                if(!"byte".equals(str)){
                    System.out.println(str);
                }else{
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
