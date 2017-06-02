package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Miha on 04.05.2017.
 */
public class MyThread extends Thread {

    static AtomicInteger priority = new AtomicInteger(0);

    public void initPriority() {
        priority.incrementAndGet();
        priority.compareAndSet(11, 1);

        setPriority(priority.get());
    }

    public MyThread() {
        initPriority();
    }

    public MyThread(Runnable runnable) {
        super(runnable);
        initPriority();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
        initPriority();
    }

    public MyThread(String s) {
        super(s);
        initPriority();
    }

    public MyThread(ThreadGroup threadGroup, String s) {
        super(threadGroup, s);
        initPriority();
    }

    public MyThread(Runnable runnable, String s) {
        super(runnable, s);
        initPriority();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s) {
        super(threadGroup, runnable, s);
        initPriority();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l) {
        super(threadGroup, runnable, s, l);
        initPriority();
    }
}
