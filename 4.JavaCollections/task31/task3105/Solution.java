package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
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

        Map<ZipEntry, StringBuffer> map = new HashMap<>();

        try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(args[1]));
             ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(args[1]))){

            String fileName = args[0];
            String zipFile = args[1];
            ZipEntry entry;
            int i;

            while ((entry = inputStream.getNextEntry()) != null) {
                StringBuffer sb = new StringBuffer();
                while ((i = inputStream.read()) != -1) {
                    sb.append((char) i);
                }
                map.put(entry, sb);
            }

            File file = new File(fileName);

            outputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
            Files.copy(file.toPath(), outputStream);

            for (Map.Entry<ZipEntry, StringBuffer> pair : map.entrySet()) {
                if (!pair.getKey().getName().equals(file.getName())) {
                    outputStream.putNextEntry(pair.getKey());
                    for (char c : pair.getValue().toString().toCharArray()) {
                        outputStream.write(c);
                    }
                } else {
                    outputStream.putNextEntry(new ZipEntry(pair.getKey().getName()));
                    Files.copy(file.toPath(), outputStream);
                }
            }
        } catch (Exception e) {
                 e.printStackTrace();
        }
    }
}
