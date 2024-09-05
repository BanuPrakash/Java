package com.spring.orderapp.dao;

import com.spring.orderapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    // projections
    List<Product> findByQuantity(int qty); // select * from products where qty = ?
    List<Product> findByNameLike(String name); // select * from products where name like %iPhone%/
    List<Product> findByPriceBetween(double low, double high); // select * from products where price >= low and price <= high
}
