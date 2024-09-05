package com.spring.orderapp.service;

import com.spring.orderapp.dao.CustomerDao;
import com.spring.orderapp.dao.ProductDao;
import com.spring.orderapp.entity.Customer;
import com.spring.orderapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private ProductDao productDao; // generated class is wired
    @Autowired
    private CustomerDao customerDao; // generated class is wired

    public List<Product> getProducts() {
        return productDao.findAll();
    }

    public Product addProduct(Product p) {
        return productDao.save(p);
    }

    public Product getProduct(int id) {
        Optional<Product> opt = productDao.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new IllegalArgumentException("Product with id " + id + " doesn't exist !!!");
        }
    }
    public Customer saveCustomer(Customer c) {
        return customerDao.save(c);
    }

    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }
}
