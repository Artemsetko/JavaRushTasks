package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    static Random r;

    static {
        r = new Random(System.currentTimeMillis());
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
        for (int i = 0; i < 20; i++) {
            ByteArrayOutputStream pass = Solution.getPassword();
            System.out.println(pass);
        }
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        String digits = "0123456789";
        String lettersLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String lettersUpperCase = lettersLowerCase.toUpperCase();

        String sum = digits + lettersLowerCase + lettersUpperCase;
        String result = generatePassword(sum);
        while (!isValidPassword(result)) {
            result = generatePassword(sum);
        }
        byte[] array = result.getBytes();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(array);

        return outputStream;
    }

    public static boolean isValidPassword(String pass) {
        boolean hasOneDigit = false;
        boolean hasOneUpperCaseLetter = false;
        boolean hasOneLowerCaseLetter = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                hasOneDigit = true;
            } else if (Character.isLowerCase(pass.charAt(i))) {
                hasOneLowerCaseLetter = true;
            } else if (Character.isUpperCase(pass.charAt(i))) {
                hasOneUpperCaseLetter = true;
            }
        }
        return hasOneDigit && hasOneUpperCaseLetter && hasOneLowerCaseLetter;
    }

    public static String generatePassword(String sum) {
        String result = "";
        for (int i = 0; i < 8; i++) {
            char c = sum.charAt(r.nextInt(sum.length()));
            result += String.valueOf(c);
        }
        return result;
    }
}