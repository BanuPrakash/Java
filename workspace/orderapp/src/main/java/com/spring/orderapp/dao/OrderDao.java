package com.spring.orderapp.dao;

import com.spring.orderapp.dto.OrderReport;
import com.spring.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {

   // @Query(nativeQuery = true, value = " select new com.spring.orderapp.dto.OrderReport(c.fname, c.lname,  o.order_date,   o.total)  from orders o join customers c  on c.email=o.customer_fk")
    @Query("select new com.spring.orderapp.dto.OrderReport(c.firstName, c.lastName, o.orderDate, o.total) from Order o inner join o.customer c")
    List<OrderReport> getReport();
}
