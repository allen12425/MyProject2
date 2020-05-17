package com.edward.fileIo;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        //test8();
        //test9();
    }

    static void test9() {
        //在填写文件路径时，一定要写上具体的文件名称（xx.txt），否则会出现拒绝访问。
        File file = null;
        try {
            file = new File("e:\\a\\b.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //先得到文件的上级目录，并创建上级目录，在创建文件
        file.getParentFile().mkdir();
        //创建文件
        try {
            file.createNewFile();
        } catch (IOException e) {

        }
        System.out.println("aaaaa");
    }

    //8.便利目录
    static void test8() {
        File f = new File("d:\\aa\\1.jpg");
        File[] files = f.listFiles();
        for (File f1 : files) {
            System.out.println(f1.getName());
        }
    }

    //文件测试
    static void test7() {
        File file = new File("d:\\hello.txt");
        System.out.println(file.canRead());
        System.out.println(file.isDirectory());
        System.out.println(file.canWrite());
    }

    //6.重命名
    static void test6() {
        File file = new File("d:\\test.txt");
        File file1 = new File("d:\\hello.txt");
        boolean b = file.renameTo(file1);
        System.out.println(b);
    }

    //5.获得文件信息
    static void test5() {
        File file = new File("d:\\ccc.txt");
        String fileName = file.getName();
        String ap = file.getAbsolutePath();
        File file1 = file.getAbsoluteFile();
        System.out.println("文件名" + fileName);
        System.out.println("绝对路径" + ap);
        System.out.println(file1);
    }

    //4.删除文件
    static void test4() {
        File file = new File("d:\\test.txt");
        boolean b = file.delete();
        System.out.println(b);
    }

    //3.创建目录
    static void test3() {
        File file = new File("d:\\a\\b\\c");
        //boolean b  = file.mkdir();//创建单级目录
        boolean b = file.mkdirs();//创建多级目录
        System.out.println(b);
    }

    //2.创建新文件
    static void test2() {
        File file = new File("d:\\test.txt");
        File file1 = new File("d:" + File.separator + "aaa.txt");
        try {
            boolean b = file.createNewFile();
            file1.createNewFile();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1.创建文件对象
    static void test1() {
        String path = "D:\\abc.txt";
        File file = new File(path);
        System.out.println(file.exists());

        String path1 = "d:\\";
        String file1 = "aa.txt";
        File f1 = new File(path1, file1);
        System.out.println(f1.exists());
    }
}
