package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
            String n1 = console.readLine();
            String n2 = console.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(n1));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(n2));

            while (fileReader.ready()) {
                String s = fileReader.readLine();
                fileWriter.write(s.replaceAll("[\\p{Punct}\\n]",""));
            }
            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
