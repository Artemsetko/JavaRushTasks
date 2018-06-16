package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        int digits = 0;
        for (char c : telNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            }
        }
        if (digits == 12) {
            Pattern pattern = Pattern.compile("" +
                    "[\\+]{1}\\d{1,}([\\(]{1}\\d{3}[\\)]{1})?\\d{1,}[\\-]?\\d+[\\-]?\\d+");
            Matcher matcher = pattern.matcher(telNumber);
            boolean result = matcher.matches();
            return result;
        }
        if (digits == 10){
            Pattern pattern = Pattern.compile("([\\(]{1}\\d{3}[\\)]{1})?\\d{1,}[\\-]?\\d+[\\-]?\\d+");
            Matcher matcher = pattern.matcher(telNumber);
            boolean result = matcher.matches();
            return result;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] s = {
                "",
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "0501236",
                "(0)501234567",
                "+38(050)1-23-45--6-7",
                "+3-8(050)1-23-45--6-7",
                "+38050123-4567-"
        };
        //s[1].matches("^\\+\\d{12}$");
         for (String t : s) System.out.printf("%25s :   %5s %n", t, checkTelNumber(t));
       // checkTelNumber("+38050123-45-67b");
    }
}
