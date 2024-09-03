package com.adobe.prj.client;

import com.adobe.prj.util.Computation;

public class AnonymousExample {
    public static void main(String[] args) {
        // c1 is an object of anonymous class
        Computation<Integer> c1 = new Computation<Integer>() {
            @Override
            public Integer compute(Integer v1, Integer v2) {
                return v1  + v2;
            }
        };
        System.out.println(c1.compute(3,5));
        System.out.println(c1.getClass());
        Computation<Double> c2 = new Computation<Double>() {
            @Override
            public Double compute(Double v1, Double v2) {
                return v1  + v2;
            }
        };

        System.out.println(c2.compute(1.3,3.5));
        System.out.println(c2.getClass());

        System.out.println("Lambda Expression =====>");
        // lambda
        Computation<Integer> c3 = (Integer v1, Integer v2) -> {
            return v1  + v2;
        };
        System.out.println(c3.compute(99,35));
        System.out.println(c3.getClass());

        // Type inference
        // no need for braces if its single statement
        Computation<Integer> c4 = (v1, v2) ->  v1  + v2;

        System.out.println(c4.compute(99,35));
        System.out.println(c4.getClass());

    }
}
