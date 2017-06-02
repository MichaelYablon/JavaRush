package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
             ){

            String file1, file2, file3;
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();

            FileInputStream in = new FileInputStream(file1);
            FileOutputStream out1 = new FileOutputStream(file2);
            FileOutputStream out2 = new FileOutputStream(file3);
            while (in.available() > 0){
                byte[] buffer1 = new byte[in.available() / 2 + in.available() % 2];
                byte[] buffer2 = new byte[in.available() / 2];

                out1.write(buffer1, 0, in.read(buffer1));
                out2.write(buffer2, 0, in.read(buffer2));
            }
            in.close();
            out1.close();
            out2.close();
        }
    }
}
