package com.edward.IO;

import java.io.*;

public class BufferReadDemo {

    public static void main(String[] args) {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        {
            try {
                byte[] buffer = new byte[1024];
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt")));

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
