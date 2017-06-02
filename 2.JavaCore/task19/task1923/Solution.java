package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");

                for (String s : line) {
                    if (!s.matches("^\\D*$")) writer.write(s + " ");
                }
            }
        }
    }
}
