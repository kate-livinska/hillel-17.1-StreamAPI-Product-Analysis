package app;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> categories = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        Optional<Map.Entry<String, Double>> result = categories.entrySet().stream()
                        .max(Comparator.comparing(Map.Entry::getValue));

        result.ifPresent(x -> System.out.println("Результат: " + x.getKey()));

        // or, if we want to see the average price in category too:
        // result.ifPresent(x -> System.out.println("Результат: " + x.getKey() + ", середня ціна: " + x.getValue()));
    }
}
