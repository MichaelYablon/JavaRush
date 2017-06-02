package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* 
Только для богачей
*/

public class Solution {

    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            map.put("Lastname" + i, random.nextInt(1000));
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
//        map.entrySet().removeIf(entry -> entry.getValue() < 500 );

        for(Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() < 500) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}