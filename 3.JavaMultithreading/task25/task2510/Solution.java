package com.javarush.task.task25.task2510;

/*
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
      setUncaughtExceptionHandler((thread1, throwable) -> {
            if (throwable instanceof Error) System.out.println("Нельзя дальше работать");
            else if (throwable instanceof Exception) System.out.println("Надо обработать");
            else System.out.println("ХЗ");
        });
    }

    public static void main(String[] args) {
    }
}
