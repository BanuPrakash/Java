package com.spring.orderapp.service;

import com.spring.orderapp.dao.CustomerDao;
import com.spring.orderapp.dao.OrderDao;
import com.spring.orderapp.dao.ProductDao;
import com.spring.orderapp.dto.OrderReport;
import com.spring.orderapp.entity.Customer;
import com.spring.orderapp.entity.LineItem;
import com.spring.orderapp.entity.Order;
import com.spring.orderapp.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// facade on DAO tier code
@Service
public class OrderService {
    @Autowired
    private ProductDao productDao; // generated class is wired
    @Autowired
    private CustomerDao customerDao; // generated class is wired
    @Autowired
    private OrderDao orderDao;

    public List<OrderReport> getReport() {
        return orderDao.getReport();
    }

    // custom INSERT, DELETE or UPDATE needs @Transactional
    @Transactional
    public Product changePrice(int id, double price) {
        productDao.updateProductPrice(id, price);
        return getProduct(id);
    }

    public List<Product> byRange(double low, double high) {
        return productDao.findByPriceBetween(low, high);
    }

    /*
    {
        "customer": {
            "email": "anna@adobe.com"
        },
        //  order.getItems();
        "items": [
            { "product": {"id": 5}, qty: 2},
            {"product": { id: 2}, qty: 1}
        ]
    }
     */
    @Transactional
    public String placeOrder(Order order) {
        double total = 0.0;
        List<LineItem> items = order.getItems();
        for(LineItem item: items) {
            Product p = getProduct(item.getProduct().getId()); //65 line
            if(item.getQty() > p.getQuantity()) {
                throw new IllegalArgumentException("Product " + p.getName() + " not is Stock!!!");
            }
            p.setQuantity(p.getQuantity() - item.getQty()); // DIRTY CHECKING --> UPDATE
            item.setAmount(p.getPrice() * item.getQty()); // product price + qty - discount + tax
            total += item.getAmount();
        }
        order.setTotal(total);
        orderDao.save(order); // saves order and it's line-items --> cascade
        return "Order Placed!!!";
    }

    // EAGER fetch gives line-items also
    // gets Customer also because ManyToOne is EAGER by default
    public List<Order> getOrders() {
        return  orderDao.findAll();
    }
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

    // how many customer rows in table
    public long getCustomerCount() {
        return customerDao.count();
    }
}
