package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        long n0 = 0;
        long n1 = 1;
        long n2 = 1;
        long n3 = 0;
        for (int i = 2; i <= n; i++) {
            n3 = n2 + n1 + n0;
            n0 = n1;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}

