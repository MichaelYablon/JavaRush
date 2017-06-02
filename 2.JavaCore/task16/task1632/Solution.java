package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);


    public static void main(String[] args) {
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
    }
    static {
        threads.add(new Nit_1());
        threads.add(new Nit_2());
        threads.add(new Nit_3());
        threads.add(new Nit_4());
        threads.add(new Thread5());
    }
    public static class Nit_1 extends Thread {
        @Override
        public void run() {
            while(true);
        }
    }
    public static class Nit_2 extends Thread {
        @Override
        public void run() {
            try {
                sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Nit_3 extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static class Nit_4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }
        @Override
        public void run() {
            //showWarning();
            super.run();
        }
    }
    private static class Thread1  extends Thread{
        @Override
        public void run() {
            while (true) {}
        }
    }

    private static class Thread2  extends Thread{
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    private static class Thread3 extends Thread{
        @Override
        public void run() {
            try
            {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
            super.run();
        }

        @Override
        public void showWarning() {
            if (this.isAlive()) this.interrupt();
        }
    }

    private static class Thread5 extends Thread{
        @Override
        public void run() {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String str = reader.readLine();
                int sum = 0;

                while (!str.equals("N")) {
                    sum += Integer.parseInt(str);
                    str = reader.readLine();
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}