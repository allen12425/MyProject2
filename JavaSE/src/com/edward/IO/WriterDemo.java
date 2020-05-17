package com.edward.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {
        File file = new File("writer.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("www.mashibing.com");
            writer.write("马士兵教育");

            /**
             * 什么时候需要加flush,什么时候不加flush
             *   最保险的方式，在输出流关闭之前都flush下
             *    当某一个输出流对象中带有缓冲区的时候，就需要进行flush
             *
             */

            writer.flush();//理解为将管道里剩余的水强制放到池里
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
