package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine())) {
            int min = 256;
            int r;
            while (in.available() > 0) {
                if ((r = in.read()) < min) min = r;
            }
            System.out.println(min);
        }

    }
}
