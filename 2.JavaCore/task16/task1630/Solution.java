package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String filename;
        StringBuilder sum = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return sum.toString();
        }

        @Override
        public void run() {

            String line;

            try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
                while (true) {
                    line = in.readLine();
                    if (line == null) break;
                    else sum.append(line).append(" ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
