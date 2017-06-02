package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double count = 0;
        for (int i = 1; i > 0; i++) {
            int a = Integer.parseInt(reader.readLine());
            if( a == -1) {
                System.out.println((double)(sum/count));
                break;
            }
            sum += a;
            count++;

        }



    }
}

