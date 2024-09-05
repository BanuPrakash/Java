package com.spring.orderapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="order_date")
    private Date orderDate = new Date(); //system date

    @ManyToOne
    @JoinColumn(name="customer_fk") // Foreign key column
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "order_fk")
    private List<LineItem> items = new ArrayList<>();

    private double total;
}
