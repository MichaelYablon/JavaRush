package com.javarush.task.task15.task1522;

/**
 * Created by Miha on 14.04.2017.
 */
public class Sun implements Planet{
    private static Sun instance;

    public static Sun getInstance() {
        if (instance == null) instance = new Sun();
        return instance;
    }

    private Sun() {
    }
}
