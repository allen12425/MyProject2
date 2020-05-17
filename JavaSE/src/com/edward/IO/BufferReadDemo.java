package com.edward.IO;

import java.io.*;

public class BufferReadDemo {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        byte[] buffer = new byte[1024];
        try (BufferedReader bufferedReader1 = bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt")))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
