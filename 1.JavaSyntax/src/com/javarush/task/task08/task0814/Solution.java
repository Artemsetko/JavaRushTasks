package com.javarush.task.task08.task0814;

import java.util.*;

/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; set.size() < 20; ) {
            set.add(random.nextInt(40));
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        ArrayList<Integer> listFirst = new ArrayList<>();
        for (Integer integer : set) {
            if (integer > 10)
                listFirst.add(integer);
        }
        set.removeAll(listFirst);
        return set;
    }

    public static void main(String[] args) {

    }
}
