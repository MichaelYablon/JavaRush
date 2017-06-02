package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        byte[] key = new byte[] {1,2,3,4,5};

        switch (args[0]) {
            case "-e": {
                try (FileInputStream fileReader = new FileInputStream(args[1]);
                     FileOutputStream fileWriter = new FileOutputStream(args[2])){

                    while (fileReader.available() > 0) {
                        byte[] buff = new byte[fileReader.available()];
                        fileReader.read(buff);

                        //XOR Code
                        int j = 0;
                        for (int i = 0; i < buff.length; i++) {
                            buff[i] = (byte) (buff[i] ^ key[j]);
                            if (j > key.length)
                                j = 0;
                        }
                        fileWriter.write(buff);
                    }
                }
                break;
            }
            case "-d": {
                try (FileInputStream fileReader = new FileInputStream(args[1]);
                     FileOutputStream fileWriter = new FileOutputStream(args[2])){

                    while (fileReader.available() > 0) {
                        byte[] buff = new byte[fileReader.available()];
                        fileReader.read(buff);

                        //XOR Code
                        int j = 0;
                        for (int i = 0; i < buff.length; i++) {
                            buff[i] = (byte) (buff[i] ^ key[j]);
                            if (j > key.length)
                                j = 0;
                        }
                        fileWriter.write(buff);
                    }
                }
                break;
            }
        }
    }
}
