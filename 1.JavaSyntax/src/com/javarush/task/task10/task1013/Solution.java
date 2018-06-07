package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.

*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private Human father;
        private Human mother;
        private int salary;

        public Human(){

        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public Human(String name, int age, boolean sex, int salary) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.salary = salary;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother, int salary) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
            this.salary = salary;
        }

        public Human(String name, Human father, Human mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        public Human(Human father, Human mother) {
            this.father = father;
            this.mother = mother;
        }

        public Human(boolean sex, int salary) {
            this.sex = sex;
            this.salary = salary;
        }
    }
}
