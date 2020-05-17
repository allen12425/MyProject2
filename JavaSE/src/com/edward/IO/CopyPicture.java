package com.edward.IO;

import java.io.*;

public class CopyPicture {
    public static void main(String[] args) {
        /**
         * 字符流适合处理纯文本，图片应用字节流
         */

        FileReader reader =  null;
        FileWriter writer = null;
        try {
            reader = new FileReader("1.jpg");
            writer = new FileWriter("2.jpg");
            int length = 0;
            char[] chars = new char[1024];
            while ((length = reader.read(chars)) != -1) {
                writer.write(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
