package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = "c:\\result.mp3";
        String pathToZip = "c:\\pathToTest\\test.zip";
        File file = new File(fileName);

        Map<String, ByteArrayOutputStream> achievedFiles = new HashMap<>();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(pathToZip))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                int count = 0;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                while ((count = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }
                achievedFiles.put(entry.getName(), baos);
            }
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(pathToZip))) {
            for (Map.Entry<String, ByteArrayOutputStream> entry : achievedFiles.entrySet()) {
                if (entry.getKey().substring(entry.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zos.putNextEntry(new ZipEntry(entry.getKey()));
                zos.write(entry.getValue().toByteArray());
            }
            ZipEntry newZipEntry = new ZipEntry("new/" + file.getName());
            zos.putNextEntry(newZipEntry);
            Files.copy(file.toPath(), zos);
        }


    }
}
