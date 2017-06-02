package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String str = reader.readLine();
            int i;
            String newStr = null;
            if (str.contains("?")) {
                i = str.indexOf("?");
                newStr = (str.substring(i + 1));
            }

            String[] params = newStr.split("&");
            ArrayList<String> values = new ArrayList<>();
            for (String param : params) {
                if (param.contains("=") && (param.substring(0, param.indexOf("=")).equals("obj"))) {
                    values.add(param.substring(param.indexOf("=") + 1));
                    param = param.substring(0, param.indexOf("="));
                    System.out.print(param + " ");
                }
                else if (param.contains("=")) {
                    param = param.substring(0, param.indexOf("="));
                    System.out.print(param + " ");
                }
                else System.out.print(param + " ");
            }
            System.out.println();
            for (String value : values) {
                if (isNumeric(value)) {

                    alert(Double.parseDouble(value));
                }
                else {
                    alert(value);
                }
            }



        } catch (IOException e ) {}
    }
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
