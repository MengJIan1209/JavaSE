package com.meng.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("F:\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另一个文件，名为haha.txt

        File file1 = new File("F:\\io\\io1\\haha.txt");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }


    }


}
