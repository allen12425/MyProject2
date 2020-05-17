package com.edward.IO;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class InputStreamReaderDemo {
    public static void main(String[] args) {

      /*  try {
            ServerSocket serverSocket = new ServerSocket(10086);
            Socket socket = serverSocket.accept();
            socket.getInputStream();
            socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /**
         * 在真实的网络传输上基本都时字节流，所以InputStreamReader可以将字节流转为字符流提高效率
         */
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            char[] chars = new char[1024];
            int length = inputStreamReader.read(chars);
            System.out.println(new String(chars,0,length));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
