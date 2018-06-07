package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<String> products = new ArrayList<>();
        while (reader.ready()) {
            products.add(reader.readLine());
        }
        reader.close();
        switch (args[0]) {
            case "-u": {
                if (args.length < 5) return;
                int idfromCommand = 0;
                float price = 0.0f;
                int quantity = 0;
                String productName;

                try {
                    idfromCommand = Integer.parseInt(args[1]);
                    price = Float.parseFloat(args[args.length - 2]);
                    quantity = Integer.parseInt(args[args.length - 1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
//если количество параметров больше пяти из-за пробелов в имени продукта
                if (args.length > 5) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 2; i < args.length - 2; i++) {
                        stringBuilder.append(args[i]).append(" ");
                    }
                    productName = stringBuilder.toString();
                    productName = productName.trim();
                } else {
                    productName = args[2];
                }
// Get id from line and update
                Pattern p = Pattern.compile("([0-9]{1,8})");
                for (int i = 0; i < products.size(); i++) {
                    String s = products.get(i);
                    Matcher m = p.matcher(s);
                    if (m.lookingAt()) {
                        try {
                            int id = Integer.parseInt(s.substring(m.start(), m.end()));
                            if (id == idfromCommand) {
                                products.set(i, String.format(Locale.ROOT, "%-8d%-30s%-8.2f%-4d", id, productName, price, quantity));
                                break;
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        }
                    }
                }

                break;
            }

            case "-d": {
                Iterator<String> iterator = products.iterator();
                while (iterator.hasNext()) {
                    String product = iterator.next();
                    if (product.startsWith(args[1])) {
                        iterator.remove();
                    }
                }
                break;
            }
        }
        PrintWriter filewriter = new PrintWriter(fileName);
        for (String product : products) {
            filewriter.println(product);
        }
        filewriter.close();
    }
}
