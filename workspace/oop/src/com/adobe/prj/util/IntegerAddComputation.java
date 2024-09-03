package com.adobe.prj.util;

// Avoid, prefer anonymous class or Lambda
public class IntegerAddComputation implements  Computation<Integer>{
    @Override
    public Integer compute(Integer v1, Integer v2) {
        return v1  + v2;
    }
}
