package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(340, "iPhone 15", 99000.00, "mobile"));
        products.add(new Product(516, "Onida Thunder", 3500.00, "tv"));
        products.add(new Product(161, "Sony Bravia", 2_45_000.00, "tv"));
        products.add(new Product(65, "Oppo", 8900, "mobile"));
        products.add(new Product(90, "OnePlus 14", 78000, "mobile"));
        products.add(new Product(321, "Logitech Mouse", 450.00, "computer"));
       // Predicate  boolean test(T t); is passed as argument to filter
        // forEach takes Consumer; void accept(T t);
        products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));
        System.out.println("******");
        // map is used to transform the data
        products.stream().map(p -> p.getName()).forEach(name -> System.out.println(name));

        System.out.println("******");
        // can be written as
        Stream<String> nameStream = products.stream().map(p -> p.getName());
        nameStream.forEach(name -> System.out.println(name));

        System.out.println("******");
        
    }
}


