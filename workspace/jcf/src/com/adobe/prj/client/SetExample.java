package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>(); // TreeSet --> self study
        products.add(new Product(340, "iPhone 15", 99000.00, "mobile"));
        products.add(new Product(516, "Onida Thunder", 3500.00, "tv"));
        products.add(new Product(161, "Sony Bravia", 2_45_000.00, "tv"));
        products.add(new Product(65, "Oppo", 8900, "mobile"));
        products.add(new Product(90, "OnePlus 14", 78000, "mobile"));
        products.add(new Product(321, "Logitech Mouse", 450.00, "computer"));
        products.add(new Product(161, "Sony Bravia", 2_45_000.00, "tv")); // duplicate, not added

        for(Product p : products) {
            System.out.println(p);
        }

        // can't use Collections.sort(products);
    }
}
