package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка - конец ввода данных.
Числа могут повторяться.
Строки всегда уникальны.
Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.
Каждую пару с новой строки.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мыла
2 Рама
1 Мама
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = createHashMap();
        printHashMap(map);
    }

    public static HashMap<String, Integer> createHashMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        do {
            String s = reader.readLine();
            if (s.isEmpty()) return hashMap;
            int id = Integer.parseInt(s);
            s = reader.readLine();
            String name = s;
            hashMap.put(name, id);
        } while (true);
    }

    public static void printHashMap(HashMap<String, Integer> hashMap){
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getValue()+" "+ entry.getKey());
        }
    }
}
