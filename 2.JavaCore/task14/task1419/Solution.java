package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        System.out.println(exceptions.size());
        for (Exception exception : exceptions) {

            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            float i = 1 / 0;
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {
            throw new IOException();
        } catch (IOException e) {
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }
        try {
            throw new LambdaConversionException();
        } catch (LambdaConversionException e) {
            exceptions.add(e);
        }
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException e) {
            exceptions.add(e);
        }
        try {
            throw new ReflectiveOperationException();
        } catch (ReflectiveOperationException e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
    }
}
