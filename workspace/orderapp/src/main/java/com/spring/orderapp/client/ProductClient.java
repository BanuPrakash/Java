package com.spring.orderapp.client;

import com.spring.orderapp.entity.Product;
import com.spring.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class ProductClient implements CommandLineRunner {
    @Autowired
    private OrderService service;

    @Override
    public void run(String... args) throws Exception {
//        addProduct();
       // printAllProducts();
        printByRange();
    }

    private void printByRange() {
        List<Product> products = service.byRange(5_000, 50_000);
        for(Product p : products) {
            System.out.println(p);
        }
    }

    private void printAllProducts() {
        List<Product> products = service.getProducts();
        for(Product p : products) {
            System.out.println(p);
        }
    }

    private void addProduct() {
//        Product p1 = new Product(0, "Bosch Dish Washer", 52000.00, 100);
        Product p = Product.builder().
                name("Bosch DishWasher").
                price(52000.00).
                quantity(100).
                build();
        System.out.println(service.addProduct(p));
    }
}
