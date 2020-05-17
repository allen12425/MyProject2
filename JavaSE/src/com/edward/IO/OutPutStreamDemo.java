package com.edward.IO;

import java.io.*;

public class OutPutStreamDemo {
    public static void main(String[] args) {
        File file = new File("abc.txt");
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(99);
            out.write("\r\nmashibing".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
