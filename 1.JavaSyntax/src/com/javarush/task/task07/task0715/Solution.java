package com.javarush.task.task07.task0715;

import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
1. Создай список из слов "мама", "мыла", "раму".
2. После каждого слова вставь в список строку, содержащую слово "именно".
3. Вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<>();   //создание списка
        Collections.addAll(list1, "мама", "мыла", "раму");

        for (int i = 0; i < list1.size(); i++) {
            if (i + 1 <= list1.size()) {
                list1.add(i + 1, "именно");
                i++;
            } else continue;
        }

        for (String s : list1) {
            System.out.println(s);
        }
    }
}
