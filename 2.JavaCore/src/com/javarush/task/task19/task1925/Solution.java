package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> longWords = new ArrayList<>();
        while (fileReader.ready()) {
            String in = fileReader.readLine();
            String[] parts = in.split(" ");
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].length() > 6) {
                    longWords.add(parts[i]);
                }
            }
        }
        fileReader.close();
        for (int i = 0; i < longWords.size(); i++) {
            if (i != longWords.size() - 1) {
                fileWriter.write(longWords.get(i) + ",");
            } else {
                fileWriter.write(longWords.get(i));
            }
        }
        fileWriter.close();

    }
}
