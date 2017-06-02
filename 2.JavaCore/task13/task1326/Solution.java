package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
            ArrayList<Integer> list = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int data = scanner.nextInt();
                if (data % 2 == 0) {
                    list.add(data);
                }
            }
            scanner.close();
            reader.close();
            Collections.sort(list);
            for (int as : list) if (as % 2 == 0) System.out.println(as);
        } catch (IOException e) {

        }

    }
}
