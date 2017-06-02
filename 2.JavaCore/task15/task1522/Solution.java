package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String key = reader.readLine();
            if (key.equals(Planet.MOON)) thePlanet = Moon.getInstance();
            else if (key.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
            else if (key.equals(Planet.SUN)) thePlanet = Sun.getInstance();
            else thePlanet = null;
        } catch (IOException e) {}
    }
}
