package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Miha on 13.05.2017.
 */
public class Solution {

    public static void main(String[] args) {
        StorageStrategy strategy3 = new HashMapStorageStrategy();
        testStrategy(strategy3, 100);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings)
            result.add(shortener.getId(s));
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys)
            result.add(shortener.getString(key));
        return result;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finish = new Date();

        Helper.printMessage(Long.toString(finish.getTime() - start.getTime()));

        start = new Date();
        Set<String> strs = getStrings(shortener, ids);
        finish = new Date();

        Helper.printMessage(Long.toString(finish.getTime() - start.getTime()));

        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
