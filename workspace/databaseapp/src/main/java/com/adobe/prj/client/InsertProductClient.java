package com.adobe.prj.client;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class InsertProductClient {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl();

        Product p = new Product(0, "Wacom", 5900.00);

        try {
            productDao.addProduct(p);
            System.out.println("Product added Successfully!!!");
        } catch (PersistenceException e) {
            //System.out.println(e.getMessage()); // for end user
            e.printStackTrace(); // for developers
        }
    }
}
