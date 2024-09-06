package com.spring.orderapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 10, message = "Price has to be {value}, you entered ${validatedValue}")
    private double price;

    @Min(value = 1, message = "Quantity has to be {value}, you entered ${validatedValue}")
    @Column(name = "qty")
    private int quantity;
}
