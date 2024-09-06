package com.spring.orderapp.client;

import com.spring.orderapp.dto.OrderReport;
import com.spring.orderapp.entity.Customer;
import com.spring.orderapp.entity.LineItem;
import com.spring.orderapp.entity.Order;
import com.spring.orderapp.entity.Product;
import com.spring.orderapp.service.EntityNotFoundException;
import com.spring.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderClient implements CommandLineRunner {
    @Autowired
    private OrderService service;

    @Override
    public void run(String... args) throws Exception {
       // newOrder();
       // printOrders();
        printReport();
    }

    private void printReport() {
        List<OrderReport> reports = service.getReport();
        for(OrderReport o: reports) {
            System.out.println(o);
        }
    }

    private void printOrders() {
        List<Order> orders = service.getOrders();
        for(Order o : orders) {
            System.out.println(o.getCustomer().getFirstName() + "," + ", " + o.getTotal() + ", " + o.getOrderDate());
            List<LineItem> items = o.getItems();
            for(LineItem item : items) {
                System.out.println(item.getProduct().getName() +", " + item.getQty() + ", " + item.getAmount());
            }
            System.out.println("*******");
        }
    }
    private void newOrder() {
        Order order = new Order();
        Customer c = Customer.builder().email("anna@adobe.com").build();
        order.setCustomer(c); // order is by a customer

        LineItem item1 = LineItem.builder()
                .product(Product.builder().id(6).build())
                .qty(2)
                .build();

        LineItem item2 = LineItem.builder()
                .product(Product.builder().id(1).build())
                .qty(1)
                .build();
        order.getItems().add(item1);
        order.getItems().add(item2);
        try {
            service.placeOrder(order);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
