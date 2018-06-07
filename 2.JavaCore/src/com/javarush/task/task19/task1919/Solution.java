package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        TreeMap<String, Double> workers = new TreeMap<>();

        while (reader.ready()) {
            String s = reader.readLine();
            String[] nameAndWages = s.split(" ");
            String name = nameAndWages[0];
            Double value = Double.parseDouble(nameAndWages[1]);
            if (!workers.containsKey(name)) {
                workers.put(name, value);
            } else {
                workers.put(name, workers.get(name) + value);
            }
        }
        reader.close();

        for (Map.Entry<String, Double> entry : workers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
