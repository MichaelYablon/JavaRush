package com.javarush.task.task38.task3810;

public @interface Date {
    java.util.Date date = new java.util.Date();
    int year();
    int month();
    int day();
    int hour();
    int minute();
    int second();

}
