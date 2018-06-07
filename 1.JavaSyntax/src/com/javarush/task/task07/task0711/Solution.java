package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Удалить и вставить
1. Создай список строк.
2. Добавь в него 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            list.add(s);
        }

        for (int i = 0; i < 13; i++) {
            String tmp = list.remove(list.size() - 1);
            list.add(0, tmp);
        }

        for (String s : list) {
            System.out.println(s);
        }

    }
}
