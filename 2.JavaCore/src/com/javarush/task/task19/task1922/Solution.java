package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader file = new BufferedReader(new FileReader(fileName));

        while (file.ready()) {
            String s = file.readLine();
            int count = 0;
            for (String word : words) {
                Pattern p = Pattern.compile("\\b"+word+"\\b");
                Matcher m = p.matcher(s);
                while (m.find()) count++;
            }
            if (count == 2)
                System.out.println(s);
        }
        file.close();
    }
}
