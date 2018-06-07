package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        switch (args[0]) {
            case "-c":
                int id = 1;
                while (reader.ready()) {
                    String line = reader.readLine();
                    String idString = line.substring(0, 8);
                    int value = Integer.parseInt(idString.trim());
                    if (value > id) id = value;
                }
                id++;
                String idValue = String.valueOf(id);
                reader.close();
                String productName = args[1];
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(productName);
                    for (int i = 0; i < 30 - productName.length(); i++) {
                        sb.append(" ");
                    }
                    productName = sb.toString();
                }
                String price = args[2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(price);
                    for (int i = 0; i < 8 - price.length(); i++) {
                        sb.append(" ");
                    }
                    price = sb.toString();
                }
                String quantity = args[3];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(quantity);
                    for (int i = 0; i < 4 - quantity.length(); i++) {
                        sb.append(" ");
                    }
                    quantity = sb.toString();
                }
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
                writer.newLine();
                writer.write(idValue);
                writer.write(productName);
                writer.write(price);
                writer.write(quantity);
                writer.close();
                break;
        }
    }
}

