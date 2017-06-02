package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                try {
                    thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String str = String.format("%s, %s, %s", secretKey, thread.getName(), throwable.getMessage());
                System.out.println(str);
            }
        }

        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            // setDaemon(true);

        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }


    }

}

