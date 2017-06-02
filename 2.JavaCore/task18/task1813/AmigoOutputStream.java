package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";

    FileOutputStream fileOutputStream;

    AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        String s = "JavaRush © All rights reserved.";
        write(s.getBytes());
        fileOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void write(int i) throws IOException {
        fileOutputStream.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        fileOutputStream.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        fileOutputStream.write(bytes, i, i1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
