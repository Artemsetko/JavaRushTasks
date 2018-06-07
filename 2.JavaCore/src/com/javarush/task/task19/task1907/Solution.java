package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        Scanner sc = new Scanner(fileReader);

        int count = 0;

        Pattern p = Pattern.compile("\\bworld\\b");

        while (sc.hasNext()){
            String s = sc.nextLine();
            Matcher m = p.matcher(s);
            while (m.find()) count++;
        }
        fileReader.close();
        sc.close();

        System.out.println(count);
    }
}
