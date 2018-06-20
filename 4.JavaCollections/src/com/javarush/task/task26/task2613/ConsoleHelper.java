package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String input = null;
        try {
            input = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(input.equalsIgnoreCase("EXIT"))
            throw new InterruptOperationException();
        return input;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Введите код валюты");
        String code = readString();
        while (code.length() != 3) {
            writeMessage("Данные некорректны. Повторите ввод");
            code = readString();
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Ввести два целых положительных числа. Первое число - номинал, второе - количество банкнот.");
        String[] inputTwoDigits;
        while (true) {
            inputTwoDigits = readString().split(" ");

            int nominal = 0;
            int total = 0;

            try {
                nominal = Integer.parseInt(inputTwoDigits[0]);
                total = Integer.parseInt(inputTwoDigits[1]);
            } catch (Exception e) {
                writeMessage("Error, repeat again");
                continue;
            }

            if (nominal <= 0 || total <= 0) {
                writeMessage("Error, repeat again");
                continue;
            }
            break;
        }
        return inputTwoDigits;
    }

    public static Operation askOperation() throws InterruptOperationException {
        do {
            writeMessage("Choice operation:\n1) INFO\n2) DEPOSIT\n3) WITHDRAW\n4) EXIT");
            try {
                String input = readString();
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(input));
            } catch (IllegalArgumentException e){
                writeMessage("Input wrong, try again");
                continue;
            }
        } while (true);

    }
}
