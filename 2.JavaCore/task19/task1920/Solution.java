package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
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
           double max = Collections.max(map.values());

            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() == max)
                    System.out.println(entry.getKey());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
