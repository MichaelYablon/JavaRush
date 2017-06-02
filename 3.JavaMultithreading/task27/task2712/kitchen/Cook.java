package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Miha on 05.05.2017.
 */
public class Cook extends Observable implements Observer {

    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object o) {

        Order order = (Order) o;
        ConsoleHelper.writeMessage("Start cooking - " + o);
        setChanged();
        notifyObservers(o);
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(observable.toString(), this.name, order.getTotalCookingTime() * 60, order.getDishes()));
    }
}
