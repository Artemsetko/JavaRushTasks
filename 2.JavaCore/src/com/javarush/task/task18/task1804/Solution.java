package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        Map<Integer, Integer> map = new HashMap<>();
        while (file.available() > 0) {
            int data = file.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        file.close();

        ArrayList<Integer> val = new ArrayList<>(map.values());
        Collections.sort(val);

        Integer minRepeatsByte = val.get(0);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(minRepeatsByte)){
                System.out.print(entry.getKey().intValue()+" ");
            }
        }

    }
}
