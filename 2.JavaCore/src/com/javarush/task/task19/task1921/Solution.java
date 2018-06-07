package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String s = reader.readLine();
            String name = s.replaceAll("[^a-zA-ZА-Яа-я \\-]", "").trim();
            String d = s.replaceAll("[^0-9 ]", "").trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            try {
                Date date = sdf.parse(d);
                PEOPLE.add(new Person(name, date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        reader.close();

    }
}
