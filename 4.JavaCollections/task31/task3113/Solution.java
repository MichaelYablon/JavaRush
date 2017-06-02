package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Path path = Paths.get(reader.readLine());
            if (!Files.isDirectory(path)) {
                System.out.println (path.toString ( ) + " - не папка");
                return;
            }

            SearchFileVisitor searchFileVisitor = new SearchFileVisitor ( );
            Files.walkFileTree(path, searchFileVisitor);


            long sizeOfFiles    = searchFileVisitor.getSize ( );
            int  numFiles       = searchFileVisitor.getCountFiles ( );
            int  numDirectories = searchFileVisitor.getCountDirs ( );

            System.out.println ("Всего папок - " + (numDirectories-1));
            System.out.println ("Всего файлов - " + numFiles);
            System.out.println ("Общий размер - " + sizeOfFiles);
        }
    }
}
