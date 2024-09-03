package com.adobe.prj.client;

import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Product;
import com.adobe.prj.util.SQLProcessor;

public class AnnotationClient {
    public static void main(String[] args) {
        String SQL = SQLProcessor.getCreateSQL(Product.class);
        System.out.println(SQL);

        SQL = SQLProcessor.getCreateSQL(Book.class);
        System.out.println(SQL);

        Book b = new Book("H134", 568.11);

        SQL = SQLProcessor.generateInsertSQL(b);
        // insert into books values ('h124', 568.11); --> task
    }
}
