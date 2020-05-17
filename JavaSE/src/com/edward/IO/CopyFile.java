package com.edward.IO;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        //定义源数据文件
        File src = new File("abc.txt");
        //定义目标数据文件
        File dest = new File("aaa.txt");

        //创建输入流对象
        InputStream in = null;
        //创建输出流对象
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);

            //带缓存的输入输出方式
            byte[] buffer = new byte[1024];
            int legth = 0;
            while ((legth = in.read(buffer)) != -1) {
                out.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
