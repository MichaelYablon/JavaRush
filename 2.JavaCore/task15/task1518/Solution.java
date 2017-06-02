package com.javarush.task.task15.task1518;

/* 
Статики 3
*/

public class Solution {
    public static Cat cat = new Cat();
    static {
        System.out.println(cat.name);
    }

    public static class Cat {
        public String name = "Solo";
    }

    public static void main(String[] args) {

    }
}
