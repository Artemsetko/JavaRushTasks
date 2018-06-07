package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        int min = Integer.MAX_VALUE;
        while (file.available() > 0) {
            int data = file.read();
          //  System.out.println(data);
            if (data < min) {
                min = data;
            }
        }
        file.close();
        System.out.println(min);

    }
}
