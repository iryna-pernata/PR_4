package org.example;


import com.github.javafaker.Faker;
import org.example.Clothing;
import org.example.Electronics;
import org.example.OrderProcessor;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var faker = new Faker();

        // Створення замовлень
        OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(new Electronics("Mobile phone", 45000, "New features"));
        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(new Clothing("Trousers", 40, "Size M"));

        // Збереження замовлень
        OrderStorage<OrderProcessor<?>> orderStorage = new OrderStorage<>();
        orderStorage.saveOrder(electronicsOrder);
        orderStorage.saveOrder(clothingOrder);

        // Створення списку одягу
        var clothingList = IntStream.range(0, 10).mapToObj(i -> new OrderProcessor<>(
                Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price(10, 100000).replace(",", ".")))
                        .description(faker.lebowski().quote())
                        .build())).toList();

        // Збереження і паралельна обробка замовлень
        clothingList.forEach(orderStorage::saveOrder);
        orderStorage.startParallelProcessing();
    }
}

