package com.nhnacademy.thread_pool;

public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");

        RunnableCounter thread1 = new RunnableCounter(group, "worker1", 100);
        RunnableCounter thread2 = new RunnableCounter(group, "worker2", 100);

        thread1.start();
        thread2.start();

        Thread.sleep(5000);
        group.interrupt();
    }
}
