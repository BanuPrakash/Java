package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(340, "iPhone 15", 99000.00, "mobile"));
        products.add(new Product(516, "Onida Thunder", 3500.00, "tv"));
        products.add(new Product(161, "Sony Bravia", 2_45_000.00, "tv"));
        products.add(new Product(65, "Oppo", 8900, "mobile"));
        products.add(new Product(90, "OnePlus 14", 78000, "mobile"));
        products.add(new Product(321, "Logitech Mouse", 450.00, "computer"));

        Collections.sort(products);// Collections are similar to Arrays but can be used only on list containers

        for(Product p : products) {
            System.out.println(p);
        }

        System.out.println("Sort by Price");
        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        for(Product p : products) {
            System.out.println(p);
        }
    }
}
