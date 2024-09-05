package com.spring.orderapp.client;

import com.spring.orderapp.entity.Customer;
import com.spring.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class CustomerClient implements CommandLineRunner {
    @Autowired
    private OrderService service;

    @Override
    public void run(String... args) throws Exception {
       // addCustomers();
       // printCustomers();
    }

    private void printCustomers() {
        List<Customer> customers = service.getCustomers();
        for(Customer c : customers) {
            System.out.println(c);
        }
    }

    private void addCustomers() {
        // if no customers
        if(service.getCustomerCount() == 0) {
            service.saveCustomer(Customer.builder()
                    .email("anna@adobe.com")
                    .firstName("Anna")
                    .lastName("Helen").build());
            service.saveCustomer(Customer.builder()
                    .email("roger@adobe.com")
                    .firstName("Roger")
                    .lastName("Smith").build());
        }
    }
}
