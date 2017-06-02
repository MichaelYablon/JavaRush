package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> letters = new TreeSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String string;
            while (reader.ready()) {
                string = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]","");
                for (int i = 0; i < string.length(); i++) {
                    letters.add(string.charAt(i));
                }
            }
        }
        Iterator<Character> iterator = letters.iterator();
        int n = letters.size() < 5 ? letters.size() : 5;

        for (int i = 0; i < n; i++) {
            System.out.print(iterator.next());
        }
    }
}
