package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog {
    //напишите тут ваш код
    String name, color;
    int height;

    public void initialize(String name){
        this.name = name;
        this.color = "white";
        this.height = 1;
    }
    public void initialize(String name, int height){
        this.name = name;
        this.height = height;
        this.color = "white";
    }
    public void initialize(String name, int height, String color){
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
