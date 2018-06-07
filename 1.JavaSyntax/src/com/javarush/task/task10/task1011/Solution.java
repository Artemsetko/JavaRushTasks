package com.javarush.task.task10.task1011;

/* 
Большая зарплата
Вывести на экран надпись "Я не хочу изучать Java, я хочу большую зарплату" 40 раз по образцу.

Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
...
зарплату
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] chars = s.toCharArray();
        //напишите тут ваш код

        for (int i = -1; i < 39; i++) {
            for (int j = i+1; j < chars.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

}

