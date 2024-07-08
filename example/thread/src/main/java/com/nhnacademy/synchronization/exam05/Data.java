package com.nhnacademy.synchronization.exam05;

import java.time.LocalTime;

public class Data {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized String receive() {
        while (transfer) {
            try {
                System.out.println(LocalTime.now() + ": wait " + Thread.currentThread().getName());
                wait();
                System.out.println(LocalTime.now() + ": Wakeup " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(LocalTime.now() + " : Thread Interrupted");
            }
        }
        transfer = true;

        String returnPacket = packet;
        notifyAll();
        System.out.println(LocalTime.now() + ": notifyAll " + Thread.currentThread().getName());
        return returnPacket;
    }

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                System.out.println(LocalTime.now() + ": wait sender1");
                wait();
                System.out.println(LocalTime.now() + ": Wakeup sender2");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(LocalTime.now() + " : Thread Interrupted");
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
        System.out.println(LocalTime.now() + ": notifyAll " + Thread.currentThread().getName());
    }
}