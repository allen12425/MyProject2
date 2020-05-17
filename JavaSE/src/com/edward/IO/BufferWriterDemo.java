package com.edward.IO;

import java.io.*;

public class BufferWriterDemo {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("abc.txt"));
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("mashibing");
            bufferedWriter.newLine();
            bufferedWriter.append("马士兵教育");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
