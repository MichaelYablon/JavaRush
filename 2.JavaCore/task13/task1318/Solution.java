package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(new FileInputStream(reader.readLine()))) {

            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }


        } catch (IOException e) {}


    }
}