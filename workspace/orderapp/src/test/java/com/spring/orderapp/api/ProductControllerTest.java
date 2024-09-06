package com.spring.orderapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.orderapp.entity.Product;
import com.spring.orderapp.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// If we need to check security also
// @WebAppConfiguration
// @AutoConfigureMockMvc
// @SpringBootTest(classes = OrderappApplication.class)
// allows us to create MockUser

// else
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    private OrderService service;

    @Autowired
    private MockMvc mvc;

    // test spec
    @Test
    public void getProductsTest() throws  Exception {
        // mock the data instead of getting from database
        List<Product> products = Arrays.asList(Product.builder().id(100).name("A").price(5000).quantity(500).build(),
                Product.builder().id(101).name("B").price(9800).quantity(100).build());

        // mocking
        when(service.getProducts()).thenReturn(products);

        mvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("A")));

        verify(service,times(1)).getProducts();
    }

    @Test
    public void addProductTest() throws  Exception {
        // client code --> ID is not set AUTO INCREMENT
        Product p = Product.builder().name("Dummy").price(13333).quantity(12).build();
        // client converts Object to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p); // Product to JSON

        when(service.addProduct(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));

        mvc.perform(    post("/api/products")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(service,times(1)).addProduct(Mockito.any(Product.class));
    }

    @Test
    public void addInvalidProductTest() throws  Exception {
        // Validation should fail
        Product p = Product.builder().price(-999).quantity(0).build();
        // client converts Object to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p); // Product to JSON
        // no need to mock because Service code should not be called @valid
       // when(service.addProduct(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));

        mvc.perform(  post("/api/products")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors", hasSize(3)))
                .andExpect(jsonPath("$.errors", hasItem("Name is required")))
                .andExpect(jsonPath("$.errors", hasItem("Price has to be 10, you entered -999.0")));

        //verify(service,times(1)).addProduct(Mockito.any(Product.class));
        verifyNoInteractions(service);
    }
}
