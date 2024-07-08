package com.nhnacademy.thread_class_extension;

public class Quiz02 {
    public static void main(String[] args) {
        ThreadCounter threadCounter = new ThreadCounter("threadCounter", 10);

        threadCounter.start();
    }
}
