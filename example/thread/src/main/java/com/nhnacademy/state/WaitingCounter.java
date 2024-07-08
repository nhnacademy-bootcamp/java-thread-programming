package com.nhnacademy.state;

public class WaitingCounter implements Runnable {
    Thread thread;
    RunnableCounter counter;

    public WaitingCounter(RunnableCounter counter) {
        thread = new Thread(this);
        this.counter = counter;
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    @Override
    public void run() {
        try {
            counter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
