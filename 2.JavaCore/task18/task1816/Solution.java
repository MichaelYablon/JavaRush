package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileReader in = new FileReader(args[0])) {
            String alphabetL = "abcdefghijklmnopqrstuvwxyz";
            String alphabetH = alphabetL.toUpperCase();

            int count = 0;
            while (in.ready()) {
                char s = (char) in.read();
                if ((alphabetL.indexOf(s) > -1) || alphabetH.indexOf(s) > -1)
                    count++;
            }
            System.out.println(count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}