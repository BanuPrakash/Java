package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.Arrays;
import java.util.Comparator;

public class SortClient {
    public static void main(String[] args) {
        String[] names = {"George", "Brad", "Angelina", "Uma", "Jeniffer", "Rachel"};
        Arrays.sort(names); // Comparable interface, logic is in String class compareTo()
        for(String name: names) {
            System.out.println(name);
        }

//        Comparator ==> int compare(T o1, T o2);
        System.out.println("sort by length");
        Arrays.sort(names, (s1, s2) -> s1.length() - s2.length()); // Comparator, logic is in client
        for(String name: names) {
            System.out.println(name);
        }

        Product[] products = new Product[6]; // Array of Pointers
        products[0] = new Product(340, "iPhone 15", 99000.00, "mobile"); // upcasting
        products[1] = new Product(516, "Onida Thunder", 3500.00, "tv");
        products[2] = new Product(161, "Sony Bravia", 2_45_000.00, "tv");
        products[3] = new Product(65, "Oppo", 8900, "mobile");
        products[4] = new Product(90, "OnePlus 14", 78000, "mobile");
        products[5] = new Product(321, "Logitech Mouse", 450.00, "computer");

        Arrays.sort(products); // natural logic, Comparable , login in Product Class
        for(Product p : products) {
            System.out.println(p);
        }

        System.out.println("Sort by Price");
        //Arrays.sort(products, (p1, p2) -> (int)(p1.getPrice() - p2.getPrice()));
        Arrays.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())); // comparator, logic in client
        for(Product p : products) {
            System.out.println(p);
        }
    }
}
