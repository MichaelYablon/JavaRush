package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){

            TreeMap<String, Double> map = new TreeMap<>();

            while (reader.ready()) {
                String s = reader.readLine();
                String[] strings = s.split(" ");


                if (!map.containsKey(strings[0]))
                    map.put(strings[0], Double.parseDouble(strings[1]));
                else map.put(strings[0], map.get(strings[0]) + Double.parseDouble(strings[1]));

            }

            for (Map.Entry<String, Double> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
