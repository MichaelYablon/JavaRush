package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

    private static List<File> list = new ArrayList<>();

    public static void main(String[] args) {
        File path                   = new File (args[0]);
        File resultFileAbsolutePath = new File (args[1]);
        File destination            = new File (resultFileAbsolutePath.getParent ( ) + "/allFilesContent.txt");
        FileUtils.renameFile (resultFileAbsolutePath, destination);

        try (FileOutputStream outputStream = new FileOutputStream(destination)){
            checkSize(path);
            Collections.sort(list, Comparator.comparing(File::getName));

            for (File file : list) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    outputStream.write(reader.readLine().getBytes());
                }
                outputStream.write('\n');
                reader.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkSize(File path) {
        if (path.isDirectory()) {
            for (File file : path.listFiles()) {
                if (file.length() != 0)
                    checkSize(file);
                else FileUtils.deleteFile(file);
            }
        } else {
            if (path.length() > 50)
                FileUtils.deleteFile(path);
            else list.add(path);
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
