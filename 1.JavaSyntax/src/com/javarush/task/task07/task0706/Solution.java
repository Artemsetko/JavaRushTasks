package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
1. Создать массив на 15 целых чисел.
2. Ввести в него значения с клавиатуры.
3. Пускай индекс элемента массива является номером дома, а значение - число жителей, проживающих в доме.
Дома с нечетными номерами расположены на одной стороне улицы, с четными - на другой. Выяснить, на какой стороне улицы проживает больше жителей.
4. Вывести на экран сообщение: "В домах с нечетными номерами проживает больше жителей." или "В домах с четными номерами проживает больше жителей."

Примечание:
дом с порядковым номером 0 считать четным.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] houses = new int[15];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < houses.length; i++) {
            String s = reader.readLine();
            houses[i] = Integer.parseInt(s);
        }
        for (int i = 0; i < houses.length; i++) {
            if (i == 0 || i % 2 == 0) even += houses[i];
            else odd += houses[i];
        }
        System.out.println(compare(even, odd));
    }

    public static String compare(int even, int odd) {
        String s = even > odd ? "В домах с четными номерами проживает больше жителей." : "В домах с нечетными номерами проживает больше жителей.";
        return s;
    }
}
