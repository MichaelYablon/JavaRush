package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{
        public AmigoThreadFactory() {
            factoryNum.set(factoryCount.incrementAndGet());
        }
        AtomicInteger pool = new AtomicInteger(0);
        static AtomicInteger factoryCount = new AtomicInteger(0);
        AtomicInteger factoryNum = new AtomicInteger(0);


        @Override
        public Thread newThread(Runnable runnable) {

            Thread thread = new Thread(runnable);

            thread.setDaemon(false);
            thread.setPriority(5);

            thread.setName(thread.getThreadGroup().getName() + "-pool-" + factoryNum + "-thread-" + pool.incrementAndGet());

            return thread;
        }
    }
}
