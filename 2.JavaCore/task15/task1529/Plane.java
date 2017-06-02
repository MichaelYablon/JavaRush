package com.javarush.task.task15.task1529;

/**
 * Created by Miha on 14.04.2017.
 */
public class Plane implements Flyable {
    public int count;
    @Override
    public void fly() {

    }

    public Plane(int count) {
        this.count = count;
    }
}
