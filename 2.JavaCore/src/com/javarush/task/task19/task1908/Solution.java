package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] parseString = s.split(" ");
            for (String number : parseString) {
                if (isNumeric(number)) fileWriter.write(number + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }

    public static boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) return false;
        }
        return true;
    }
}
