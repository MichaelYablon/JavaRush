package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        try(FileReader fileReader = new FileReader(args[0])) {

            int count1 = 0;
            int count2 = 0;

            while (fileReader.ready()) {
                char data = (char)fileReader.read();
                count1++;

                if (data == ' ') count2++;
            }
            float res = (count2 / count1) * 100;
            System.out.printf("%.2f", res);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
