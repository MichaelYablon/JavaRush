package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 10.05.2017.
 */
@XmlType(name="shop")
@XmlRootElement
public class Shop
{
    @XmlElementWrapper(name="goods", nillable = true)
    public List<String> names = new ArrayList<>();
    public int count;
    public double profit;
    public Goods goods;
    public String[] secretData;

    public static class Goods {
        List<String> names;

    }
}
