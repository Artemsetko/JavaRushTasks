package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandfather1 = new Human("grandfather1", 90, true);
        Human grandfather2 = new Human("grandfather2", 80, true);
        Human grandmother1 = new Human("grandmother1", 89, false);
        Human grandmother2 = new Human("grandmother2", 82, false);
        Human father = new Human("father", 52, true);
        Human mother = new Human("mother", 50, false);
        Human child1 = new Human("child1", 22, false);
        Human child2 = new Human("child2", 24, true);
        Human child3 = new Human("child3", 25, true);
        grandfather1.children.add(father);
        grandmother1.children.add(father);
        grandfather2.children.add(mother);
        grandmother2.children.add(mother);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);
        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public int age;
        public boolean sex;
        public ArrayList<Human> children = new ArrayList<>();

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
