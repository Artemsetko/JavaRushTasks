package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isSpaceChar(string.charAt(i))){
                count++;
            }
        }
        if (count < 4) {
            throw new TooShortStringException();
        }
        String[] parts = string.split(" ");

        return parts[1] + " " + parts[2] + " " + parts[3] + " " + parts[4];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
