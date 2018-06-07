package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("Сетко", "Артем");
        dictionary.put("Сетко2", "Ирина");
        dictionary.put("Сетко3", "Александр");
        dictionary.put("Сетко4", "Анна");
        dictionary.put("Ивановико", "Артем");
        dictionary.put("Иринова", "Полина");
        dictionary.put("Иванов", "Иван");
        dictionary.put("Кныш", "Иван");
        dictionary.put("Сметаненко1", "Виктория");
        dictionary.put("Сметаненко2", "Артем");
        return dictionary;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> duplicateObjects = new ArrayList<>();
        Set<String> set = new HashSet<String>() {
            @Override
            public boolean add(String e) {
                if (contains(e)) {
                    duplicateObjects.add(e);
                }
                return super.add(e);
            }
        };
        for (String s : map.values()) {
            set.add(s);
        }

        for (String s : duplicateObjects) {
            removeItemFromMapByValue(map, s);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
