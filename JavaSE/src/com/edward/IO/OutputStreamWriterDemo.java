package com.edward.IO;

import java.io.*;

/**
 * 1.OutputStreamWriter 比 outputStream 效率更高
 * 2.OutPutStreamWriter更灵活，可以指定字符编码
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        File file = new File("abc.txt");
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;

        try {
            long start = System.currentTimeMillis();
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
            outputStreamWriter.write(99);
            outputStreamWriter.write("马士兵");
            outputStreamWriter.write("fdsafdfag",0,5);

            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流时建议按照创建的顺序的逆序来进行关闭
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
