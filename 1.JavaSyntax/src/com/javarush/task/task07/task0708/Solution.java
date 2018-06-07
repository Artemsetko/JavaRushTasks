package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        //ввод строк с клавиатуры
        strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            strings.add(s);
        }

        int max = Integer.MIN_VALUE;
        for (String s : strings) {
            if (s.length() > max) max = s.length();
        }
        for (String s : strings) {
            if (s.length() == max) System.out.println(s);
            ;
        }


    }
}
