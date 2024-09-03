package com.adobe.prj.client;

public class HashStory {
    public static void main(String[] args) {
        String s1 = new String("Aa");
        String s2 = new String("BB");

        System.out.println(s1.hashCode()); // 2112
        System.out.println(s2.hashCode()); // 2112

        String s3 = new String("Hello");
        System.out.println(s3.hashCode());
        String s4 = new String("HELLO");
        System.out.println(s4.hashCode());

        String s5 = new String("Hello");
        System.out.println(s5.hashCode());
    }
}
