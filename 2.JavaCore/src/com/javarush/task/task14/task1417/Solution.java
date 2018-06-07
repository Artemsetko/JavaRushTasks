package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //напишите тут ваш код
            this.allMoney.add(new Hrivna(9000.10));
            this.allMoney.add(new Ruble(150000.55));
            this.allMoney.add(new USD(233453.78));
            }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }

}
