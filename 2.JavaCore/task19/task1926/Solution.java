package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String a = reader.readLine();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(a));

            while (bufferedReader.ready()) {
                StringBuilder builder = new StringBuilder(bufferedReader.readLine());
                builder.reverse();
                System.out.println(builder.toString());
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
