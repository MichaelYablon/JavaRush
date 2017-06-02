package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();
    protected Size size;

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human() {
        this.id = nextId;
        nextId++;
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData()
    {
        System.out.println (getPosition ( ) + ": " + name);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child) {

        children.add(child);
    }

    public void removeChild(Human child) {

        for (int i = 0; i < children.size ( ); i++)
            if (children.get (i).equals (child))
            {
                children.remove (i);
                break;
            }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {

    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public class Size{
        public int height;
        public int weight;
    }

}