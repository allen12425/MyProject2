package com.edward.IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String str = "www.mashibing.com";
        byte[] buffer = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = null;

        byteArrayInputStream = new ByteArrayInputStream(buffer);

        int length = byteArrayInputStream.read();
        System.out.println((char) length+"------------");

        while ((length = byteArrayInputStream.read()) != -1) {
            byteArrayInputStream.skip(4);
            System.out.println((char) length);
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
