package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader readFile = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(readFile.readLine())))) {
            ArrayList<Integer> listEven = new ArrayList<>();
            String integer = "";
            while ((integer = fis.readLine()) != null) {
                int x = Integer.parseInt(integer);
                if (x % 2 == 0)
                    listEven.add(x);
            }
            Collections.sort(listEven);
            for (Integer i : listEven) {
                System.out.println(i);
            }
        }


    }
}
