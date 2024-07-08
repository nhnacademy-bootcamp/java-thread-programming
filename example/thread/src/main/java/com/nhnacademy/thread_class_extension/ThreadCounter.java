package com.nhnacademy.thread_class_extension;

public class ThreadCounter extends Thread {
    int count;
    int maxCount;

    public ThreadCounter(String name, int maxCount) {
        setName(name);
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                ++count;
                System.out.println(getName() + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCounter counter = new ThreadCounter("counter", 50);

        counter.start();
    }
}