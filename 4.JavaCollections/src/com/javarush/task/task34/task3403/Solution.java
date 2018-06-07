package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        if (n <= 1) return;
        int d = 2;
        while (n % d != 0) {
            d++;
        }
        if (d == n) {
            System.out.print(d);
            return;
        } else {
            System.out.print(d + " ");
        }
        recursion(n / d);
    }
}
