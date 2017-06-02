package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        boolean xml = false;

        try {
            properties.loadFromXML(new FileInputStream(fileName));
            xml = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!xml) {
            try {
                properties.load(new FileReader(fileName));
                return properties;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
