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

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length == 0) {
            System.out.println("Запустите программу с одним из следующих наборов парампетров: \n" +
                    "-c name1 sex1 bd1 name2 sex2 bd2 ...\n" +
                    "-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ... \n" +
                    "-d id1 id2 id3 id4 ...\n" +
                    "-i id1 id2 id3 id4 ...");
            return;
        }
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    multipleCreation(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updates(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deletion(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    identification(args);
                }
                break;
        }
    }


    public static void multipleCreation(String[] args) {
        int indicator = 1;
        while (indicator < args.length) {
            String name = args[indicator++];
            Sex sex = null;
            if (args[indicator].equals("м")) {
                sex = Sex.MALE;
            } else if (args[indicator].equals("ж")) {
                sex = Sex.FEMALE;
            }
            indicator++;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date birthDay = new Date();
            try {
                birthDay = simpleDateFormat.parse(args[indicator++]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (sex.equals(Sex.MALE)) {
                allPeople.add(Person.createMale(name, birthDay));
            } else if (sex.equals(Sex.FEMALE)) {
                allPeople.add(Person.createFemale(name, birthDay));
            }
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void updates(String[] args) {
        int indicator = 1;
        while (indicator < args.length) {
            int id = Integer.parseInt(args[indicator++]);
            String name = args[indicator++];
            Sex sex = null;
            if (args[indicator].equals("м")) sex = Sex.MALE;
            else if (args[indicator].equals("ж")) sex = Sex.FEMALE;
            indicator++;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date birthDay = new Date();
            try {
                birthDay = simpleDateFormat.parse(args[indicator++]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(sex);
            allPeople.get(id).setBirthDay(birthDay);
        }
    }

    public static void deletion(String[] args) {
        int indicator = 0;
        while (++indicator < args.length) {
            int id = Integer.parseInt(args[indicator]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
        }
    }

    public static void identification(String[] args) {
        int indicator = 0;
        while (++indicator < args.length) {
            int id = Integer.parseInt(args[indicator]);
            Person person = allPeople.get(id);
            String name = person.getName();
            Sex sex = person.getSex();
            Date birthday = person.getBirthDay();
            String sexStr = "";
            if (sex.equals(Sex.MALE))
                sexStr = "м";
            else sexStr = "ж";
            String bd = String.format("%1$td-%1$tB-%1$tY", birthday, Locale.ENGLISH);

            System.out.println(name + " " + sexStr + " " + bd);
        }
    }
}
