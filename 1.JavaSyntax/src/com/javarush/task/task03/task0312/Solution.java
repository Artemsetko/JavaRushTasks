package com.javarush.task.task03.task0312;

/* 
Конвертируем время
Добавь метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
Вызови его дважды в методе main с любыми параметрами.
Результаты выведи на экран, каждый раз с новой строки.
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertToSeconds(20));
        System.out.println(convertToSeconds(9));
    }

    public static int convertToSeconds(int hour) {
        return hour * 60 * 60;
    }
}
