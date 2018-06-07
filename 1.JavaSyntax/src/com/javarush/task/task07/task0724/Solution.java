package com.javarush.task.task07.task0724;

/* 
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
...


*/


import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human human1 = new Human("A", true, 23);
        Human human2 = new Human("B", false, 22);
        Human human3 = new Human("C", true, 24);
        Human human4 = new Human("D", false, 21);

        Human human5 = new Human("e", true, 3, human1, human2);
        Human human6 = new Human("f", true, 5, human1, human2);
        Human human7 = new Human("g", false, 6, human3, human4);
        Human human8 = new Human("h", false, 1, human3, human4);
        Human human9 = new Human("i", true, 7, human3, human4);

        for (Object allInstance : allInstances) {
            Human h = (Human) allInstance;
            System.out.println(h);
        }

    }
    private static ArrayList<Human> allInstances;

    static
    {
        allInstances = new ArrayList<>();
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            allInstances.add(this);
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
            allInstances.add(this);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















