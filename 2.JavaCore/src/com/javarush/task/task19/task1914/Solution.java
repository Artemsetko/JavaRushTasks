package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);

        String resultString = outputStream.toString().replaceAll("[^0-9+\\-* ]", "");
        String[] arr = resultString.split(" ");
        int result = 0;
        switch (arr[1]) {
            case "+":
                result = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
                break;
            case "-":
                result = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
                break;
            case "*":
                result = Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
                break;
        }

        System.out.println(resultString.trim() + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

