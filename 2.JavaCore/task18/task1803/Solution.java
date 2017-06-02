package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine())){

            HashMap<Integer, Integer> map = new HashMap<>();

            while (in.available() > 0) {
                int key = in.read();
                if (map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else map.put(key, 1);
            }

            int max = 0;
            for (Integer value : map.values()) {
                if (value > max) max = value;
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(max)) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }
}
