package com.nhnacademy.thread_class_extension;

public class Quiz03 {
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10);
        Counter counter2 = new Counter("counter2", 10);

        counter1.run();
        counter2.run();
    }
}
