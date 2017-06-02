package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Miha on 24.04.2017.
 */
public class Hippodrome {

    public List<Horse> horses;

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse horse : horses)
            horse.move();
    }

    public void print(){
        for (Horse horse : horses)
            horse.print();

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse horse = null;
        double max = 0;

        for (Horse h : horses) {
            if (h.getDistance() > max) max = h.getDistance();
        }
        for (Horse h : horses) {
            if (h.getDistance() == max) horse = h;
        }

        return horse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Solo", 3, 0));
        game.getHorses().add(new Horse("Miha", 3, 0));
        game.getHorses().add(new Horse("Alaya", 3, 0));


        game.run();

//        System.out.println(game.getWinner().getName());
        game.printWinner();

    }
}
