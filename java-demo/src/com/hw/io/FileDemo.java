package com.hw.io;

import java.io.File;
import java.io.IOException;


/**
 *
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        String path = "E:\\hw\\hello";
        File file = new File(path + "/" + "1.tmp");
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        boolean newFile = file.createNewFile();
        System.out.println(newFile);

    }
}
