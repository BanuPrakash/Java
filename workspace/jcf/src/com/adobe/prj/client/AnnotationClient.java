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
    }
}
