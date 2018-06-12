package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("olazerreerobbrezalx"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        char[] symbols = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int odds = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (map.containsKey(symbols[i])) {
                map.put(symbols[i], map.get(symbols[i]) + 1);
            } else {
                map.put(symbols[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odds++;
            }
        }
        if (odds == 0 || odds == 1) {
            return true;
        }
        return false;
    }

}
