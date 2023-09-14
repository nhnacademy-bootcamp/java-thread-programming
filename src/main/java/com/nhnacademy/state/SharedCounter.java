package com.nhnacademy.state;

public class SharedCounter implements Runnable {
    Thread thread;
    SharedCount sharedCount;
    int count = 0;
    int maxCount;
    long interval = 1000;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        thread = new Thread(this, name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }

    public void increment() {
        count++;
        sharedCount.increment();
    }

    public int getCount() {
        return count;
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

    @Override
    public void run() {
        try {
            while (getCount() < maxCount) {
                increment();
                Thread.sleep(interval);
            }
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
