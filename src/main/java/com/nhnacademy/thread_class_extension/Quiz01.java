package com.nhnacademy.thread_class_extension;

public class Quiz01 {
    public static void main(String[] args) {
        Counter counter = new Counter("counter", 10);

        counter.run();
    }
}
