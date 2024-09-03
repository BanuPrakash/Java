package com.adobe.prj.entity;

import com.adobe.prj.orm.Column;
import com.adobe.prj.orm.Table;

import java.util.Objects;

@Table(name="products")
public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;
    private String category;

    public Product() {
    }

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Column(name="PID", type = "NUMERIC(8)")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="PRD_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="PRICE", type="NUMERIC(12,2)")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="PRD_CATEGORY", type="VARCHAR(100)")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    // natural comparison --> Prefer Primary KEY / Unique field
    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
