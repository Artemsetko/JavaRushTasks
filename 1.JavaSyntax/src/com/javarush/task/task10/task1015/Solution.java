package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        int arraySize = (int) (Math.random() * 10 + 1);
        ArrayList<String>[] arrayOfStringList = new ArrayList[arraySize];
        for (int i = 0; i < arrayOfStringList.length; i++) {
            int listSize = (int) (Math.random() * 10 + 1);
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                list.add("String #" + j);
            }
            arrayOfStringList[i] = list;
        }
        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}