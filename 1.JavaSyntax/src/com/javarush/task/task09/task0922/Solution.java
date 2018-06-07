package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "2013-08-18"
Вывести на экран эту дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {
    //08/18/2013 ---> AUG 18, 2013
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String date = reader.readLine();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM/dd/yyyy");
        try {
            dateNow = formatForDateNow.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatForDateNow = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        System.out.println(formatForDateNow.format(dateNow).toUpperCase());
    }
}
