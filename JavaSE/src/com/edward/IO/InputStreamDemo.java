package com.edward.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream("abc.txt");
            int length = 0;
            while ((length = in.read()) != -1) {
                System.out.println((char)length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
