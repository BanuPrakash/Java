package com.spring.orderapp.dao;

import com.spring.orderapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    // projections
    List<Product> findByQuantity(int qty); // select * from products where qty = ?
    List<Product> findByNameLike(String name); // select * from products where name like %iPhone%/
    List<Product> findByPriceBetween(double low, double high); // select * from products where price >= low and price <= high

    @Modifying // for INSERT, DELETE and UPDATE operations --> executeUpdate
    @Query("update Product set price = :pr where id =:id") // JP-QL
    //@Query(nativeQuery = true, value = "update products set price = :pr where id =:id") // SQL
    void updateProductPrice(@Param("id") int id, @Param("pr") double price);
}
