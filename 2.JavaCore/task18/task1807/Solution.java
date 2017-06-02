package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream in = new FileInputStream(reader.readLine())){
            int count = 0;
            while (in.available() > 0) {


                int comma = in.read();
                if (comma == 44) count++;
            }

            System.out.println(count);
        }
    }
}
