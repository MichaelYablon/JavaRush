package com.javarush.task.task29.task2912;

/**
 * Created by Miha on 05.05.2017.
 */
public abstract class AbstractLogger  implements Logger{

    private int level;
    private Logger next;

    public AbstractLogger(int level) {
        this.level = level;
    }

    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }


    public void setNext(Logger next) {
        this.next = next;
    }
}
