package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by Miha on 05.05.2017.
 */
public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);

        Cook firstCook = new Cook("Amigo");
        Waiter waiter = new Waiter();
        tablet.addObserver(firstCook);
        firstCook.addObserver(waiter);

        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
