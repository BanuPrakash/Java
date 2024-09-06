package com.spring.orderapp.api;

import com.spring.orderapp.entity.Product;
import com.spring.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final OrderService service; // Constructor DI instead of @Autowired

    // GET http://localhost:8080/api/products
    /*
    returned List<Product> is given to ContentNegotiationHandlers like Jackson library
    based on Accept:application/json
    or Accept:text/xml --> JAXB or XML handler
    returned JSON / XML is added to response body and sent to client
     */
    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    // GET http://localhost:8080/api/products/3
    @GetMapping("/{pid}")
    public Product getProduct(@PathVariable("pid") int id) {
        return service.getProduct(id);
    }

    // POST http://localhost:8080/api/products
    // payload contains new product data
    /*
    @RequestBody uses HTTP header
    Content-type:application/json
    gives payload to ContentNegotiationHandlers which converts to Java Object
     @ResponseBody is optional
     */
    @PostMapping
    public @ResponseBody Product addProduct(@RequestBody Product p) {
        return service.addProduct(p);
    }
}
