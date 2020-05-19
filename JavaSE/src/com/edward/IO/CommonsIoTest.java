package com.edward.IO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

public class CommonsIoTest {

    public static void main(String[] args) {
       long length =  FileUtils.sizeOf(new File("abc.txt"));
        System.out.println(length);

        try {
       Collection<File> files =  FileUtils.listFiles(new File("c:"), EmptyFileFilter.NOT_EMPTY,null);
            for (File file:files){
                System.out.println(file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
