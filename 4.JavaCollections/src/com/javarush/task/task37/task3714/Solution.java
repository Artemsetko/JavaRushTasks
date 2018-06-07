package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int[] num = new int[s.length()];
        for (int i = 0; i < s.toUpperCase().toCharArray().length; i++) {
            int n = letterToNumber(s.charAt(i));
            num[i] = n;
        }
        int res = num[num.length - 1];
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] == -1) {
                System.out.println("Вы ввели неверное число");
                return -1;
            }
            if (num[i - 1] >= num[i])
                res += num[i - 1];
            else {
                res -= num[i - 1];
            }
        }
        return res;
    }

    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;

            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
