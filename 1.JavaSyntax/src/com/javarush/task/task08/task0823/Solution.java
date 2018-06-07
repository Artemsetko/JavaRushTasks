package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String[] arrayString = s.trim().split("\\s+");
        for (String s1 : arrayString) {
            char[] s1Array = s1.toCharArray();
            s1Array[0] = Character.toUpperCase(s1Array[0]);
            s1 = new String(s1Array);
            System.out.print(s1 + " ");
        }

    }
}
