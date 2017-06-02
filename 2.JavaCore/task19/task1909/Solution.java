package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
                String strings = reader.readLine().replace(".", "!");
                writer.write(strings);
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
