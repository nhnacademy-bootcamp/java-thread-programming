package com.nhnacademy.state;

public class Exam02 {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);

        runnableCounter.start();
        System.out.println(runnableCounter.getThread().getState());
    }
}
