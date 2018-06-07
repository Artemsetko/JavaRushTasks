package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("Сетко1","Артем");
        dictionary.put("Сетко2","Ирина");
        dictionary.put("Сетко3","Александр");
        dictionary.put("Сетко4","Анна");
        dictionary.put("Ивановико","Артем");
        dictionary.put("Иринова","Полина");
        dictionary.put("Иванов","Иван");
        dictionary.put("Кныш","Иван");
        dictionary.put("Сметаненко1","Виктория");
        dictionary.put("Сметаненко2","Артем");
        return dictionary;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.values()) {
            if (name.equals(s)) count++;
            else continue;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.keySet()) {
            if (s.contains(lastName)) count=1;
            else continue;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
