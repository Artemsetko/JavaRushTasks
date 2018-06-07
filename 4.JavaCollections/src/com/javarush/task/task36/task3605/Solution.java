package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> set = new TreeSet<>();
        while (reader.ready()) {
            String s = reader.readLine().toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
        }
        int count = 0;
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            Character x = iterator.next();
            if (Character.isLetter(x)) {
                System.out.print(x);
                count++;
            }
            if (count == 5) return;
        }
    }
}
