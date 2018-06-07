package com.javarush.task.task06.task0610;

import java.util.Scanner;

/* 
Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() - читает с клавиатуры строку
int readInt() - читает с клавиатуры число
double readDouble() - читает с клавиатуры дробное число
boolean readBoolean() - читает с клавиатуры строку "true" или "false"
и возвращает соответствующую логическую переменную true или false

Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода.
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        return new Scanner(System.in).nextLine();
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        return new Scanner(System.in).nextInt();
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        return new Scanner(System.in).nextDouble();
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        return new Scanner(System.in).nextBoolean();
    }

    public static void main(String[] args) {

    }
}
