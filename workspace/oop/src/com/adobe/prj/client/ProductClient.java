package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // Array of Pointers
        products[0] = new Mobile(34, "iPhone 15", 99000.00, "5G"); // upcasting
        products[1] = new Tv(56, "Onida Thunder", 3500.00, "CRT");
        products[2] = new Tv(61, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(65, "Oppo", 8900, "4G");
        products[4] = new Mobile(90, "OnePlus 14", 78000, "4G");

        printExpensive(products);
        printDetails(products);
    }

    private static void printDetails(Product[] products) {
        for(Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice() );
            // do typechecking before down casting
            // can use instanceof or getClass() to do the typechecking
            if(p instanceof Mobile) { // family of
                Mobile m = (Mobile) p;
                System.out.println(m.getConnectivity());
            } else if(p.getClass() == Tv.class) { // strict checking compared to instanceof
                Tv t = (Tv) p;
                System.out.println(t.getScreenType());
            }
        }
    }

    // OCP, closed for Change Open for Extension
    private static void printExpensive(Product[] products) {
        for(Product p : products) {
            if(p.isExpensive()) { // polymorphic behaviour , dynamic binding
                System.out.println(p.getName() + " is expensive");
            } else {
                System.out.println(p.getName()  + " is not expensive");
            }
        }
    }
}
