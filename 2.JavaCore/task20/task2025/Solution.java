package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add((long)i);
        }

        for (Long i : list) {
            String[] strings = String.valueOf(i).split("");
            int amount = strings.length;
            long summ = 0;
            for (String s : strings) {
                summ += Math.pow(Long.parseLong(s),amount);
            }

            if (i != summ) list.remove(i);
        }
        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        getNumbers(10);
    }
}
