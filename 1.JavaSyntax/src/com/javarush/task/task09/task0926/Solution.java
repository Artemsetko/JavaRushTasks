package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] five, two, four, seven, zero;
        five = new int[]{1, 2, 3, 4, 5};
        two = new int[]{6, 7};
        four = new int[]{8, 9, 10, 11};
        seven = new int[]{12, 13, 14, 15, 16, 17, 18};
        zero = new int[0];
        list.add(five);
        list.add(two);
        list.add(four);
        list.add(seven);
        list.add(zero);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
