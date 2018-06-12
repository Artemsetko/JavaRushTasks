package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(242));
    }

    public static boolean isPowerOfThree(int n) {
        double power = 1;
        for (int i = 0; i < n; i++) {
            power = Math.pow(3, (double) i);
            if (power > n) return false;
            if (power == n) return true;
        }
        return false;
    }
}
