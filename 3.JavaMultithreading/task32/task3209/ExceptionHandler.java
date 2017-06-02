package com.javarush.task.task32.task3209;

/**
 * Created by Miha on 04.05.2017.
 */
public class ExceptionHandler extends Exception {

    public static void log(Exception e) {
        System.out.println(e.toString());
    }
}
