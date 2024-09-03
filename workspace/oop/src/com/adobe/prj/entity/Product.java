package com.adobe.prj.entity;

public abstract class Product implements  Comparable<Product>{
    private int id; // state
    private String name; // state
    private double price; // state

    @Override
    public int compareTo(Product o) {
        return (int) (this.price - o.price);
    }

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isExpensive() {
//        return false;
//    }
    public abstract boolean isExpensive();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
