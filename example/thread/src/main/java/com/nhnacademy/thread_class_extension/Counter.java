package com.nhnacademy.thread_class_extension;

public class Counter {
    String name;
    int count;
    int maxCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
    }

    public void run() {
        while (count < maxCount) {
            try {
                ++count;
                System.out.println(name + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter("counter", 50);

        counter.run();
    }
}