package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Miha on 08.05.2017.
 */
public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private int  countDirs  = 0;
    private int  countFiles = 0;
    private long size = 0;

    public int getCountDirs() {
        return countDirs;
    }

    public int getCountFiles() {
        return countFiles;
    }

    public long getSize() {
        return size;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        countFiles++;
        size += Files.size(path);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        countDirs++;
        return FileVisitResult.CONTINUE;
    }
}
