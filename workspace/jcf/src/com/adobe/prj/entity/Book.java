package com.adobe.prj.entity;

import com.adobe.prj.orm.Column;
import com.adobe.prj.orm.Table;

@Table(name="books") // setting the name property
public class Book {
    private String isbn;
    private double price;

    public Book() {
    }

    public Book(String isbn, double price) {
        this.isbn = isbn;
        this.price = price;
    }

    @Column(name="BOOK_ISBN")
    public String getIsbn() {
        return isbn;
    }

    @Column(name="AMOUNT", type = "NUMERIC(10, 2)")
    public double getPrice() {
        return price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
