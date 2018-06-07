package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name (String), age (int), address (String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате: name + " " + age + " " + address
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Vasya",23,"Lenina 46");
        Man man2 = new Man("Kolya", 33,"Balzaka 101");
        System.out.println(man1);
        System.out.println(man2);

        Woman woman1 = new Woman("Viktoriya", 40,"Mayakovskogo 5");
        Woman woman2 = new Woman("Anna", 20,"Bulgakova 4");
        System.out.println(woman1);
        System.out.println(woman2);

    }

    //напишите тут ваш код
    public static class Man {
        String name, address;
        int age;

        public Man(String name, int age, String address) {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        String name, address;
        int age;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
