package com.edward.IO;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        char[] chars = "马士兵教育".toCharArray();
        StringBuffer sbf = new StringBuffer();
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        try {
            int read = 0;
            while ((read = charArrayReader.read()) != -1) {
                sbf.append(((char)read));
            }
            System.out.println(sbf.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayReader.close();
        }
    }
}
