package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream in = new FileInputStream(reader.readLine())) {
            int max = 0;
            int r;
            while (in.available() > 0) {
                if((r = in.read()) > max) {max = r;}
            }
            System.out.println(max);
        }
    }
}
