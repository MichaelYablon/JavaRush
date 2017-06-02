package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Miha on 01.05.2017.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String message = null;
        boolean ret = false;

        while (!ret) {
            try {
                message = reader.readLine();
                ret = true;
            } catch (IOException e) {
                writeMessage ("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                message = null;
            }
        }
        return message;
    }

    public static int readInt() {
        int result = 0;

        try {
            result = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            result = readInt ( );
        }

        return result;
    }
}
