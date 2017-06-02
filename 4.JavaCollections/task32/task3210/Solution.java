package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        byte[] buff = new byte[text.length()];

        raf.seek(number);

        raf.read(buff, 0, text.length());

        String str = new String(buff);

        raf.seek(raf.length());

        if (str.equals(text)) raf.write("true".getBytes());
        else raf.write("false".getBytes());

        raf.close();
    }
}
