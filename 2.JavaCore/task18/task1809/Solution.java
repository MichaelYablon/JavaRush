package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {



        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

             ){
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            FileInputStream in = new FileInputStream(file1);
            FileOutputStream out = new FileOutputStream(file2);

            Stack<Integer> stack = new Stack<>();

            while (in.available() > 0) {
                int a = in.read();
                stack.push(a);
            }

            while (!stack.isEmpty()) out.write(stack.pop());

            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
