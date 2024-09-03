package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Util;

public class ComparableClient {
    public static void main(String[] args) {
        String[] names = {"George", "Brad", "Angelina", "Uma", "Jeniffer", "Rachel"};

        Util.sort(names);

        for(String name: names) {
            System.out.println(name);
        }

        Product[] products = new Product[5]; // Array of Pointers
        products[0] = new Mobile(34, "iPhone 15", 99000.00, "5G"); // upcasting
        products[1] = new Tv(56, "Onida Thunder", 3500.00, "CRT");
        products[2] = new Tv(61, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(65, "Oppo", 8900, "4G");
        products[4] = new Mobile(90, "OnePlus 14", 78000, "4G");

        Util.sort(products); // Product implements Comparable

        for(Product p : products) {
            System.out.println(p); // directly passing Object as argument to println --> toString() of Object
        }

    }
}
