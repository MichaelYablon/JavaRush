package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(reader.readLine());
        }
        int max = arr.get(0).length();
        int maxIndex = 0;
        int minIndex = 0;
        int min = arr.get(0).length();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() > max) {
                max = arr.get(i).length();
                maxIndex = i;
            }
            else if (arr.get(i).length() < min) {
                min = arr.get(i).length();
                minIndex = i;
            }
        }
        if (maxIndex < minIndex)
            System.out.println(arr.get(maxIndex));
        else
            System.out.println(arr.get(minIndex));
    }
}
