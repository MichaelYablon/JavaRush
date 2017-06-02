package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat infoDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]){
            case ("-c"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=3) createPerson(args[i], args[i + 1], args[i + 2]);
                break;
                }
            }
            case ("-u"): {
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i += 4){
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        if (args[i + 2].equals("м")) person.setSex(Sex.MALE);
                        else if (args[i + 2].equals("ж")) person.setSex(Sex.FEMALE);
                        person.setBirthDay(dateFormat.parse(args[i + 3]));
                    }
                break;
                }
            }
            case ("-d"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++){
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                    }
                break;
                }
            }
            case ("-i"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++){
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + infoDate.format(person.getBirthDay()));
                    }
                break;
                }
            }
        }

    }
    public static void createPerson(String name, String sex, String birthday) throws ParseException{
        if (sex.equals("ж")) allPeople.add(Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday)));
        else if (sex.equals("м")) allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday)));
        System.out.println(allPeople.size() - 1);
    }
}
