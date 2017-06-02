package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine())){

            HashMap<Integer, Integer> map = new HashMap<>();

            while (inputStream.available() > 0) {

                int key = inputStream.read();
                if (map.containsKey(key)) map.put(key, map.get(key) + 1);
                else map.put(key, 1);
            }

            int min = 256;
            for (Integer value : map.values()) {
                if (value < min) min = value;
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(min)) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }

    }
}
