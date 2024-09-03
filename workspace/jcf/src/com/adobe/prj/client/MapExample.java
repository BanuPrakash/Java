package com.adobe.prj.client;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("JavaScript", 890.00);
        map.put("Java", 1200.00);
        map.put("Oracle DB", 780.22);
        map.put("Spring", 3450.00);

        map.put("Java", 2100.00); // since key is same, bucket entry is overwritten

        System.out.println(map.get("JavaScript")); // 890.00, pass the key, we get value

        // traverse through each entry in buckets
        map.forEach((key,value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
