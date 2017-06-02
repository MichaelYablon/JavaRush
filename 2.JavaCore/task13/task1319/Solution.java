package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())))
        ) {
            String line;
            while (!(line = reader.readLine()).equals("exit")) {
                writer.write(line);
                writer.newLine();
            }
            writer.write("exit");

        } catch (IOException e) {

        }
    }
}
