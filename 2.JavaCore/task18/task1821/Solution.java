package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream reader = new FileInputStream(args[0])){

            TreeMap<Byte, Integer> map = new TreeMap<>();

            while (reader.available() > 0) {

                byte[] buf = new byte[reader.available()];
                reader.read(buf);

                for (int i = 0; i < buf.length; i++) {
                    if (map.containsKey(buf[i])) map.put(buf[i], map.get(buf[i]) + 1);
                    else map.put(buf[i], 1);
                }

            }

            for (Map.Entry entry : map.entrySet()) {
                System.out.println((char)((byte)entry.getKey()) + " " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
