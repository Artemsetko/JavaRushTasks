package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        byte[] symbols = new byte[fileInputStream.available()];
        fileInputStream.read(symbols);
        Arrays.sort(symbols);

        Map<Byte, Integer> map = new LinkedHashMap<>();

        int count;

        for (byte symbol : symbols) {
            count = 0;
            for (byte b : symbols) {
                if (b == symbol) {
                    count++;
                }
            }
            if (!map.containsKey(symbol)) {
                map.put(symbol, count);
                System.out.println((char) symbol + " " + count);
            }
        }

        fileInputStream.close();

    }
}
