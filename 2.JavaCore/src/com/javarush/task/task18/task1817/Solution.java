package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        double symbols = 0;
        double spaces = 0;

        while (fis.available() > 0) {
            int data = fis.read();
            if (data == (int) ' ') {
                spaces++;
            } else if (data != 10 && data != 13) {
                symbols++;
            }

        }
        fis.close();
        double d = spaces / symbols * 100;
        double result = new BigDecimal(d).setScale(2, RoundingMode.UP).doubleValue();
        System.out.println(result);

    }
}
