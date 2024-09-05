package com.spring.orderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderReport {
    private String firstName; // Customer
    private String lastName; // Customer
    private Date orderDate; //Order
    private double total; // Order
}
