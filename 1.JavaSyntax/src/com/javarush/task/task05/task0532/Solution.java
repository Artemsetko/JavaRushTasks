package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        do {
            N = Integer.parseInt(reader.readLine());
        } while (N <= 0);

        int maximum = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(reader.readLine());
            if (tmp > maximum) maximum = tmp;
            else continue;
        }
        //напишите тут ваш код

        System.out.println(maximum);
    }
}
