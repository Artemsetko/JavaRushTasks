package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.


*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> listSequence = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            listSequence.add(Integer.parseInt(reader.readLine()));
        }
        int chislo = listSequence.get(0), par = 1, max = 0;
        for (int i = 1; i < 10; i++) {
            if (listSequence.get(i) == chislo) {
                par++;
                chislo = listSequence.get(i);
                if (par > max) max = par;
            } else if (listSequence.get(i) != chislo && par >= max) {
                max = par;
                par = 1;
                chislo = listSequence.get(i);
            }

        }

        System.out.println(max);
    }
}