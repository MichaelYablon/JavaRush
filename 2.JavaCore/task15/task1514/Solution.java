package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0, "One");
        labels.put(2.0, "One");
        labels.put(31.0, "One");
        labels.put(14.0, "One");
        labels.put(15.0, "One");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
