package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Date date = new Date();

        System.out.printf("%1$td %1$tm %1$tY", date);
    }
}
