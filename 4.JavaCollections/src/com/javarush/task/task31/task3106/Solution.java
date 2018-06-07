package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        File fresult = new File(resultFileName);
        if (fresult.exists()) fresult.delete();
        Files.createFile(fresult.toPath());
        String[] fileParts = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            fileParts[i - 1] = args[i];
        }
        Arrays.sort(fileParts);

        List<InputStream> streamList = new ArrayList<>();
        for (String filePart : fileParts) {
            streamList.add(new FileInputStream(filePart));
        }
        SequenceInputStream sequenceIS = new SequenceInputStream(Collections.enumeration(streamList));
        ZipInputStream zIS = new ZipInputStream(sequenceIS);
        FileOutputStream fileOS = new FileOutputStream(fresult);
        ZipEntry entry;
        byte[] buffer = new byte[1024 * 1024];
        while ((entry = zIS.getNextEntry()) != null) {
            int count;
            while ((count = zIS.read(buffer)) != -1) {
                fileOS.write(buffer, 0, count);
            }
        }
        sequenceIS.close();
        fileOS.close();
        zIS.close();
    }
}
       /* // String resultFileName = args[0];
        Path pathToResultFile = Paths.get(args[0]);
        //create paths to parts
        String[] fileNameParts = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            fileNameParts[i - 1] = args[i];
        }
        Arrays.sort(fileNameParts);

        //create result archive
        Path pathArchive = Paths.get(pathToResultFile.toString() + ".zip");
        if (Files.exists(pathArchive)) {
            Files.delete(pathArchive);
        }
        Files.createFile(pathArchive);

        //copy parts to Archive
        for (String fileNamePart : fileNameParts)
            Files.write(pathArchive, Files.readAllBytes(Paths.get(fileNamePart)), StandardOpenOption.APPEND);

        //unzip archive
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathArchive.toFile()));
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            Files.copy(zipInputStream, pathToResultFile);
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
    }*/
   /*    public class Solution {
           public static void main(String[] args) throws IOException {
               // Это решение позаимствовано отсюда
               // https://www.snip2code.com/Snippet/1178691/Level-31--Lesson-06--Bonus-01

               String resultFileName = args[0];
               int filePartCount = args.length - 1;
               String[] fileNamePart = new String[filePartCount];
               for (int i = 0; i < filePartCount; i++) {
                   fileNamePart[i] = args[i + 1];
               }
               Arrays.sort(fileNamePart);

               List<FileInputStream> fisList = new ArrayList<>();
               for (int i = 0; i < filePartCount; i++) {
                   fisList.add(new FileInputStream(fileNamePart[i]));
               }
               SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
               ZipInputStream zipInStream = new ZipInputStream(seqInStream);
               FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
               byte[] buf = new byte[1024 * 1024];
               while (zipInStream.getNextEntry() != null) {
                   int count;
                   while ((count = zipInStream.read(buf)) != -1) {
                       fileOutStream.write(buf, 0, count);
                   }
               }
               seqInStream.close();
               zipInStream.close();
               fileOutStream.close();
           }
*/