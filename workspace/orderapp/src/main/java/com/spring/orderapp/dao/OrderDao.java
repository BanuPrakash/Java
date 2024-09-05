package com.spring.orderapp.dao;

import com.spring.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
