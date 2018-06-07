package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Играем в Jолушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Порядок объявления списков очень важен.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> main = new ArrayList<Integer>();
        ArrayList<Integer> x3 = new ArrayList<Integer>();
        ArrayList<Integer> x2 = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            main.add(Integer.parseInt(reader.readLine()));
            int a2 = main.get(main.size()-1) % 2;
            int a3 = main.get(main.size()-1) % 3;
            if (a2 > 0 && a3 > 0) {
                other.add(main.get(main.size()-1));
                continue;
            }
            if (a3 == 0) x3.add(main.get(main.size()-1));
            if (a2 == 0) x2.add(main.get(main.size()-1));
        }
        printList(x3);
        printList(x2);
        printList(other);
    }

    public static void printList(List<Integer> list) {
        for (int i : list) System.out.println(i);
    }
}

