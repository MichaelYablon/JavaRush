package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public int i;
    public String string;
    public double aDouble;
    public Solution() {
    }

    Solution(int i) {
        this.i = i;
    }

    private Solution(String string) {
        this.string = string;
    }

    protected Solution(double aDouble) {
        this.aDouble = aDouble;
    }

    public static void main(String[] args) {

    }
}

