package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuffer outText = new StringBuffer("");

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String s : line) {
                    if (s.length() > 6) {
                        outText.append(s).append(",");
                    }
                }
            }

            outText.delete(outText.length() - 1, outText.length());
            writer.write(outText.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
