package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try (BufferedReader in = new BufferedReader(new FileReader(Statics.FILE_NAME))){
            String line;
            while ((line = in.readLine()) != null)
                lines.add(line);
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
