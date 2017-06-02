package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 05.05.2017.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {

        List<Dish> dishes = new ArrayList<>();

        writeMessage("Choose one dish");
        ConsoleHelper.writeMessage(Dish.allDishesToString());

        while (true) {

            String dishToOrder = readString();
            if (dishToOrder.equals("exit")) break;

            boolean found = false;

            if(dishToOrder.isEmpty()){
                writeMessage("Choose any dish from menu");
                continue;
            }

            for (Dish d : Dish.values()) {
                if (d.name().equalsIgnoreCase(dishToOrder)) {
                    found = true;
                    dishes.add(d);
                }
            }
            if (!found) {
                writeMessage("No such dish in menu");
            }
        }
        return dishes;
    }
}
