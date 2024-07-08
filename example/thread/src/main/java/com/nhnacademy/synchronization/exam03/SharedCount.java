package com.nhnacademy.synchronization.exam03;

public class SharedCount {
    static int count;

    SharedCount() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SharedCount.count = count;
    }

    public static synchronized void increment() {
        count++;
    }
}
