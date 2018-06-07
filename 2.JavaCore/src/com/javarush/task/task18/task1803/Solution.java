package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
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

        Integer maxRepeatsByte = val.get(val.size()-1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(maxRepeatsByte)){
                System.out.print(entry.getKey().intValue()+" ");
            }
        }

    }
}
