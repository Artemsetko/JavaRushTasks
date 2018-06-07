package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JUNE 11 1990"));
        map.put("Stallone2", new Date("JULY 14 1970"));
        map.put("Stallone3", new Date("JULY 13 1985"));
        map.put("Stallone4", new Date("NOVEMBER 8 1981"));
        map.put("Stallone5", new Date("MARCH 25 1984"));
        map.put("Stallone6", new Date("DECEMBER 13 1977"));
        map.put("Stallone7", new Date("AUGUST 15 1962"));
        map.put("Stallone8", new Date("JULY 17 1989"));
        map.put("Stallone9", new Date("MAY 30 1982"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        Map.Entry<String, Date> pair;
        while (iterator.hasNext()) {
            pair = iterator.next();
            if(pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8){
                iterator.remove();
            }
        }


    }

    public static void main(String[] args) {

    }
}
