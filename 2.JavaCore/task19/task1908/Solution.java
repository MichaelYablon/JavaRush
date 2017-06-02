package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
            String n1 = console.readLine();
            String n2 = console.readLine();
            BufferedReader reader = new BufferedReader(new FileReader(n1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(n2));

            while (reader.ready()) {
                String[] strings = reader.readLine().split("\\s");
                for (String s : strings) {
                    try {
                        System.out.println(Integer.parseInt(s));
                        writer.write(s + " ");
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
