package com.nhnacademy.synchronization.exam05;

public class Exam05 {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data), "sender");
        Thread receiver1 = new Thread(new Receiver(data), "receiver1");
        Thread receiver2 = new Thread(new Receiver(data), "receiver2");

        receiver1.start();
        receiver2.start();
        sender.start();
    }
}
