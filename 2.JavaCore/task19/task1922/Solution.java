package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String name = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(name));

            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");
                int count = 0;

                for (String word : words) {
                    for (String s : line) {
                        if (s.equals(word)) count++;
                    }
                }
                if (count == 2) {
                    for (String s : line)
                        System.out.println(s + " ");
                }
            }

            fileReader.close();
        }
    }
}
