package com.javarush.task.task33.task3310;

/**
 * Created by Miha on 14.05.2017.
 */
public class ExceptionHandler extends Exception {
    public static void log(Exception e){
        Helper.printMessage(e.getMessage());
    }
}
