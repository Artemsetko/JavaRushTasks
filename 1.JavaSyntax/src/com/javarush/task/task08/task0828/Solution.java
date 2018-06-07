package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        Map<String, Integer> mapOfMonth = new HashMap<>();
        mapOfMonth.put("January", 1);
        mapOfMonth.put("February", 2);
        mapOfMonth.put("March", 3);
        mapOfMonth.put("April", 4);
        mapOfMonth.put("May", 5);
        mapOfMonth.put("June", 6);
        mapOfMonth.put("July", 7);
        mapOfMonth.put("August", 8);
        mapOfMonth.put("September", 9);
        mapOfMonth.put("October", 10);
        mapOfMonth.put("November", 11);
        mapOfMonth.put("December", 12);

        int numberMonth = mapOfMonth.get(month) != null ? mapOfMonth.get(month) : 0;
        if (numberMonth != 0)
            System.out.println(month + " is the " + numberMonth + " month");
    }
}
