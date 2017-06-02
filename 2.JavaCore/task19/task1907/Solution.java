package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(name));

            int count = 0;

            String word = "world";
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String[] words = line.split("\\W");
                for (String s : words)
                    if (s.equals(word))
                        count++;
//            while ((index = s.indexOf(word, index+1)) >= 0)
//                count++;
            }

            fileReader.close();
            System.out.println(count);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
