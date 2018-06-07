package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputData;
        while (!(inputData = reader.readLine()).equals("exit")) {
            try {
                if (inputData.contains(".")) {
                    print(Double.valueOf(inputData));
                } else if (Integer.parseInt(inputData) > 0 && Integer.parseInt(inputData) < 128) {
                    print(Short.parseShort(inputData));
                } else if (Integer.parseInt(inputData) <= 0 || Integer.parseInt(inputData) >= 128) {
                    print(Integer.valueOf(inputData));
                }
            } catch (NumberFormatException e) {
                print(inputData);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
