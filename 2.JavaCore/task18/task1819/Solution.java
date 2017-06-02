package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            try (ByteArrayOutputStream mem = new ByteArrayOutputStream(1024);
                 FileInputStream in1 = new FileInputStream(file1);
                 FileOutputStream outputStream = new FileOutputStream(file1);
                 FileInputStream in2 = new FileInputStream(file2)) {

                while (in2.available() > 0) mem.write(in2.read());
                while (in1.available() > 0) mem.write(in1.read());


                mem.writeTo(outputStream);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
