package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> reachPeople = new HashMap<>();
        reachPeople.put("Сетко", 900);
        reachPeople.put("Сетко2", 100);
        reachPeople.put("Сетко3", 800);
        reachPeople.put("Сетко4", 200);
        reachPeople.put("Ивановико", 300);
        reachPeople.put("Иринова", 499);
        reachPeople.put("Иванов", 600);
        reachPeople.put("Кныш", 700);
        reachPeople.put("Сметаненко1", 1000);
        reachPeople.put("Сметаненко2", 650);
        return reachPeople;

    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()){
            if (pair.getValue() < 500){
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}