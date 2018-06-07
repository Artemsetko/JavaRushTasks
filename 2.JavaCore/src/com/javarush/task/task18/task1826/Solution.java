package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] key = {13, 14, 15, 16, 17};

        switch (args[0]) {
            case "-e": {
                FileInputStream src = new FileInputStream(args[1]);
                FileOutputStream dest = new FileOutputStream(args[2]);

                while (src.available() > 0) {
                    byte[] buffer = new byte[src.available()];
                    src.read(buffer);

                    //Xor code
                    int j = 2;
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte) (buffer[i] ^ key[j]);
                    }
                    dest.write(buffer);
                }
                src.close();
                dest.close();
                break;
            }
            case "-d":
                FileInputStream src = new FileInputStream(args[1]);
                FileOutputStream dest = new FileOutputStream(args[2]);

                while (src.available() > 0) {
                    byte[] buffer = new byte[src.available()];
                    src.read(buffer);

                    //Xor code
                    int j = 2;
                    for (int i = 0; i < buffer.length; i++) {
                        buffer[i] = (byte) (buffer[i] ^ key[j]);
                    }
                    dest.write(buffer);
                }
                src.close();
                dest.close();
                break;
        }
    }

}
