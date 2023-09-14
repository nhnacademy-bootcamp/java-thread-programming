package com.nhnacademy.thread_class_extension;

public class Quiz04 {
    public static void main(String[] args) {
        ThreadCounter threadCounter1 = new ThreadCounter("threadCounter1", 10);
        ThreadCounter threadCounter2 = new ThreadCounter("threadCounter2", 10);

        threadCounter1.start();
        threadCounter2.start();
    }
}
