package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String tag = args[0];
        StringBuilder sb = new StringBuilder();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        String data = sb.toString();
        fileReader.close();

        int count = 0;
        Pattern pattern = Pattern.compile("</" + tag + ">");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            count++;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int pos = -1;

        for (int i = 0; i < count * 2; i++) {
            int start = data.indexOf("<" + tag, pos + 1);
            int end = data.indexOf("</" + tag + ">", pos + 1);
            if (start >= 0 && start < end) {
                map.put(start, null);
                pos = start;
            } else {
                ArrayList<Integer> keys = new ArrayList<>(map.keySet());
                for (int j = keys.size() - 1; j >= 0; j--) {
                    if (map.get(keys.get(j)) == null) {
                        map.put(keys.get(j), end);
                        break;
                    }
                }
                pos = end;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(data.substring(entry.getKey(), entry.getValue() + 3 + tag.length()));
        }
    }
}
