package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            try (BufferedReader f1 = new BufferedReader(new FileReader(file1));
                FileWriter writer = new FileWriter(file2)){
                ArrayList<String> list = new ArrayList<>();

                while (f1.ready()) list.add(f1.readLine());

                ArrayList<Long> values = new ArrayList<>();
                for (String s : list) {
                    for (String part : s.split(" ")) {
                        values.add(Math.round(Double.parseDouble(part)));
                    }
                }

                for (Long value : values) writer.write(value.toString() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
