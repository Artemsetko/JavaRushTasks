package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        BufferedWriter file2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));
        ArrayList<Long> list = new ArrayList<>();

        while (file1.ready()) {
            String s = file1.readLine();
            String[] num = s.split(" ");
            for (String s1 : num) {
                list.add(Math.round(Double.parseDouble(s1)));
            }
        }
        file1.close();

        for (Long aLong : list) {
            file2.write(String.valueOf(aLong));
            file2.write(" ");
        }

        file2.close();
    }
}
