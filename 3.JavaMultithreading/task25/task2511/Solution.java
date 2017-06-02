package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                String name = thread.getName ( );
                int    ln   = name.length ( );
                String str  = throwable.getMessage ( );
                if (str.contains (thread.getName ( )))
                    str = str.replace (thread.getName ( ), repeat ("*", ln));

                System.out.println (str); ;
            }
        };
        //init handler here
    }



    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
    public String repeat(String s, int times)
    {
        if (times <= 0) return "";
        else return s + repeat (s, times - 1);
    }
}