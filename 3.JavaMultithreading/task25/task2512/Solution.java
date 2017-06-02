package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        String str = printStackThrowable (e);
        System.out.println (str);
    }

    String printStackThrowable(Throwable e)
    {
        String str =// e.getClass ( ) + ":" +
                e.toString ( ) + "\n";
        if (e.getCause() != null)
        {
            return printStackThrowable (e.getCause ( )) + str;
        }
        return str;
    }


    public static void main(String[] args) {
    }
}
