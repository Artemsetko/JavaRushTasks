package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        TreeSet<Integer> sortedSet = new TreeSet<>();
        while (file.available() > 0) {
            int data = file.read();
            sortedSet.add(data);
        }
        file.close();

        for (Integer integer : sortedSet) {
            System.out.print(integer+" ");
        }
    }
}
