package com.javarush.task.task25.task2506;

/**
 * Created by Miha on 28.04.2017.
 */
public class LoggingStateThread extends Thread{
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(thread.getState());
        State state = this.thread.getState();
        while (state != State.TERMINATED){
            if (state != this.thread.getState()) {
                state = this.thread.getState();
                System.out.println(state);
            }
        }
    }
}
