package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет

*/


public class Dog {
    //напишите тут ваш код
    String name, color;
    int height;

    public Dog(String name) {
        this.name = name;
        this.color = "white";
        this.height = 1;
    }

    public Dog(String name, int height) {
        this.name = name;
        this.height = height;
        this.color = "white";
    }

    public Dog(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
