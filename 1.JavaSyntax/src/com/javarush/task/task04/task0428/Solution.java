package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int count = 0;

       for (int i = 0; i < 3; i++) {
           int a = Integer.parseInt(reader.readLine());
           if (a > 0) count++;
       }
        System.out.println(count);
    }
}
