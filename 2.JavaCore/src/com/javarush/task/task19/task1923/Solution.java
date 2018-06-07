package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];


        BufferedReader fileFrom = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));


        while (fileFrom.ready()) {
            String s = fileFrom.readLine();
            String[] strings = s.split(" ");
            for (String string : strings) {
                if (!string.matches("\\D*") && !string.matches("\\d*")) {
                    writer.write(string+" ");
                }
            }
        }

        fileFrom.close();
        writer.close();
    }

  /*  public static boolean isStringWithNumber(String s) {
        boolean letters = false;
        boolean digits = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                letters = true;
            } else if (Character.isDigit(chars[i])) {
                digits = true;
            }
        }
        if (letters && digits) return true;
        else return false;
    }*/
}
