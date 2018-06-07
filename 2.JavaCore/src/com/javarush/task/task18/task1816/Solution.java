package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countLetters = 0;

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (matchEnglish(data)) {
                countLetters++;
            }
        }
        fileInputStream.close();
        System.out.println(countLetters);

    }

    private static boolean matchEnglish(int data) {
        String a = Character.toString((char) data);
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher matcher = p.matcher(a);
        return matcher.matches();
    }
}
