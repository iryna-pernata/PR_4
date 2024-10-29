package org.example;



import org.example.OrderProcessor;
import org.example.OrderThreadManager;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage<T extends OrderProcessor<?>> {
    private final List<T> orderList = new ArrayList<>();

    public void saveOrder(T orderProcessor) {
        orderList.add(orderProcessor);
        System.out.println("Order saved: " + orderProcessor.getProduct().getName());
    }

    public void startParallelProcessing() {
        orderList.forEach(order -> OrderThreadManager.startProcessing(() -> {
            System.out.println("Processing " + order.getProduct().getName() + " in thread: " + Thread.currentThread().getName());
        }));
    }
}

