package com.spring.orderapp.api;

import com.spring.orderapp.entity.Product;
import com.spring.orderapp.service.EntityNotFoundException;
import com.spring.orderapp.service.OrderService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
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
    // Query Parameter
    // GET http://localhost:8080/api/products?low=500&high=50000
    /*
    returned List<Product> is given to ContentNegotiationHandlers like Jackson library
    based on Accept:application/json
    or Accept:text/xml --> JAXB or XML handler
    returned JSON / XML is added to response body and sent to client
     */
    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
                                     @RequestParam(name = "high", defaultValue = "0.0") double high ) {
        if(low == 0.0 && high == 0.0) {
            return service.getProducts();
        } else  {
            return service.byRange(low,high);
        }
    }

    // GET http://localhost:8080/api/products/3
    @Operation(
            description = "Service that return a Product",
            summary = "This service returns a Product by the ID",
            responses = {
                    @ApiResponse(description = "Successful Operation", responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "404", description = "Product  Not found", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true)))
            })
    @GetMapping("/{pid}")
    public Product getProduct(@PathVariable("pid") int id) throws EntityNotFoundException {
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
    public @ResponseBody Product addProduct(@RequestBody @Valid Product p) {
        return service.addProduct(p);
    }

    // PUT or PATCH for UPDATE
    @Hidden
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) throws EntityNotFoundException{
        return service.changePrice(id, p.getPrice());
    }
}
