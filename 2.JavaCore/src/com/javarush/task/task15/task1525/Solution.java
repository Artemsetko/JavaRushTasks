package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
        } catch (FileNotFoundException e) {
            System.out.println("Change path to source file: " + e.getMessage());
        }
        String inputData;
        try {
            while ((inputData = reader.readLine()) != null) {
                lines.add(inputData);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
