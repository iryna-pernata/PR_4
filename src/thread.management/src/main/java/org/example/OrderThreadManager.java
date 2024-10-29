package org.example;


public class OrderThreadManager {
    public static void startProcessing(Runnable task) {
        new Thread(task).start();
    }
}
