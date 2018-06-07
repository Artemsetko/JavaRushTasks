package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Выражаемся покороче
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

        //ввод строк с клавиатуры
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            strings.add(s);
        }

        int min = Integer.MAX_VALUE;
        for (String s : strings) {
            if (s.length() < min) min = s.length();
        }
        for (String s : strings) {
            if (s.length() == min) System.out.println(s);
        }

    }
}
