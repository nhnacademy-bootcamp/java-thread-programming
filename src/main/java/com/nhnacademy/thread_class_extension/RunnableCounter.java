package com.nhnacademy.thread_class_extension;

public class RunnableCounter implements Runnable {
    static int totalCount = 0;
    Thread thread;
    int count;
    int maxCount;
    boolean running;

    public RunnableCounter(int maxCount) {
        this("RunnableCounter-" + totalCount, maxCount);
    }

    public RunnableCounter(String name, int maxCount) {
        totalCount++;
        this.maxCount = maxCount;
        count = 0;
        running = false;
        thread = new Thread(this, name);
    }

    public String getName() {
        return thread.getName();
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        running = false;
        thread.interrupt();
    }

    @Override
    public void run() {
        running = true;

        while (running && (count < maxCount)) {
            try {
                ++count;
                System.out.println(getName() + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter0 = new RunnableCounter(50);
        RunnableCounter runnableCounter1 = new RunnableCounter(50);

        System.out.println(runnableCounter0.getName());
        System.out.println(runnableCounter1.getName());
        runnableCounter0.start();
        runnableCounter1.start();
        System.out.println(runnableCounter0.getName());
        System.out.println(runnableCounter1.getName());

        Thread.sleep(5000);
        runnableCounter0.stop();
    }
}