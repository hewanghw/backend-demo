package com.hw.io.out;

import java.io.*;

public class OutPutStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\myOut\\out.txt");
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        OutputStream fos = new FileOutputStream(file);
        try {
            fos.write(8804);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fos.close();
        }


    }
}
