package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Random random = new Random();

        // digits
        for (int i = 0; i < 3; i++) {
            outputStream.write(48 + random.nextInt(10));
        }

        // Letters
        for (int i = 0; i < 3; i++) {
            outputStream.write(65 + random.nextInt(26));
        }

        // Capital Letters
        for (int i = 0; i < 2; i++) {
            outputStream.write(97 + random.nextInt(26));
        }


        return outputStream;
    }
}