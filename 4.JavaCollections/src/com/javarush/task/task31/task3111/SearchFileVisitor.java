package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.FileVisitResult.*;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName, partOfContent;
    private int minSize, maxSize;
    private List<Path> foundFiles = new LinkedList<>();

    boolean partOfNameCheck;
    boolean partOfContentCheck;
    boolean minSizeCheck;
    boolean maxSizeCheck;

    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;

        this.minSizeCheck = false;
        this.maxSizeCheck = false;
        this.partOfNameCheck = false;
        this.partOfContentCheck = false;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isRegularFile()) return CONTINUE;

        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (partOfNameCheck && partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            return CONTINUE;
        }


        if (partOfContentCheck && partOfContent != null && !new String(content).contains(partOfContent)) {
            return CONTINUE;
        }

        if (minSizeCheck && content.length < minSize) {
            return CONTINUE;
        }

        if (maxSizeCheck && content.length > maxSize) {
            return CONTINUE;
        }

        foundFiles.add(file);

        return CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        partOfContentCheck = true;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        maxSizeCheck = true;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
