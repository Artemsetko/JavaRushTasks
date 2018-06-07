package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length == 0) {
            System.out.println("Запустите программу с одним из следующих наборов парампетров: \n" +
                    "-c name sex bd\n" +
                    "-u id name sex bd\n" +
                    "-d id\n" +
                    "-i id");
        } else {
            //String[] args = args[0].split(" ");
            if (args[0].equals("-c")) {
                String name = args[1];
                Sex sex = null;
                if (args[2].equals("м")) sex = Sex.MALE;
                else if (args[2].equals("ж")) sex = Sex.FEMALE;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthDay = new Date();
                try {
                    birthDay = simpleDateFormat.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (sex.equals(Sex.MALE)) {
                    allPeople.add(Person.createMale(name, birthDay));
                } else if (sex.equals(Sex.FEMALE)) {
                    allPeople.add(Person.createFemale(name, birthDay));
                }
                System.out.println(allPeople.size() - 1);
            } else if (args[0].equals("-u")) {
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                Sex sex = null;
                if (args[3].equals("м")) sex = Sex.MALE;
                else if (args[3].equals("ж")) sex = Sex.FEMALE;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthDay = new Date();
                try {
                    birthDay = simpleDateFormat.parse(args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                allPeople.get(id).setName(name);
                allPeople.get(id).setSex(sex);
                allPeople.get(id).setBirthDay(birthDay);
            } else if (args[0].equals("-d")) {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            } else if (args[0].equals("-i")) {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                String name = person.getName();
                Sex sex = person.getSex();
                Date birthday = person.getBirthDay();
                String sexStr = "";
                if (sex.equals(Sex.MALE))
                    sexStr = "м";
                else sexStr = "ж";
                String bd = String.format("%1$td-%1$tb-%1$tY", birthday, Locale.ENGLISH);

                System.out.println(name + " " + sexStr + " " + bd);
            }
        }
    }
}