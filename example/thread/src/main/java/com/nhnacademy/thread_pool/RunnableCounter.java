package com.nhnacademy.thread_pool;

public class RunnableCounter implements Runnable {
    Thread thread;
    int count = 0;
    int maxCount;
    long interval = 1000;

    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        thread = new Thread(group, this, name);
        this.maxCount = maxCount;
    }

    public RunnableCounter(String name, int maxCount) {
        thread = new Thread(this, name);
        this.maxCount = maxCount;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public Thread getThread() {
        return thread;
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted() && count < maxCount) {
                increment();
                System.out.println(thread.getName() + " : " + getCount());
                Thread.sleep(interval);
            }
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
