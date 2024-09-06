package com.spring.orderapp.api;

import com.spring.orderapp.dto.OrderReport;
import com.spring.orderapp.entity.Order;
import com.spring.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        return service.placeOrder(order);
    }

    @GetMapping("/report")
    public List<OrderReport> getReport() {
        return service.getReport();
    }

    @GetMapping
    public List<Order> getOrders() {
        return service.getOrders();
    }
}
