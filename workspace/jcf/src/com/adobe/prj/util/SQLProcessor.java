package com.adobe.prj.util;

import com.adobe.prj.orm.Column;
import com.adobe.prj.orm.Table;

import java.lang.reflect.Method;

public class SQLProcessor {
    // SQLProcessor.getCreateSQL(Product.class); --> create table ..
    // SQLProcessor.getCreateSQL(Book.class); --> create table ...
    public static String getCreateSQL(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        Table table = clazz.getAnnotation(Table.class);
        if(table != null) {
            builder.append("create table ");
            builder.append(table.name());
            builder.append("("); // create table books (
            Method[] methods = clazz.getDeclaredMethods(); // not inherited
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column col = m.getAnnotation(Column.class);
                    if(col != null) {
                        builder.append(col.name());
                        builder.append(" ");
                        builder.append(col.type());
                        builder.append(",");// create table books ( BOOK_ISBN VARCHAR(255),
                    }
                }
            }
        } else {
            throw  new IllegalArgumentException("Table annotation is required!!");
        }
        builder.setCharAt(builder.lastIndexOf(","), ')');
        return builder.toString();
    }
}
