package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);

            ArrayList<Byte> list = new ArrayList<>();

            while (fileReader.ready()) {
                byte data = (byte) fileReader.read();
                list.add(data);
            }
            for (int i = 1; i < list.size(); i += 2) {
                fileWriter.write(list.get(i));
            }

            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
