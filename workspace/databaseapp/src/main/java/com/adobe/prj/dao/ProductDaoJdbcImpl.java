package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbcImpl implements  ProductDao{

    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduct(Product p) throws  PersistenceException{
        String SQL = "INSERT INTO  products (id, name, price) VALUES (0, ?, ?)";
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TRG", "root", "Welcome123");
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.executeUpdate(); //INSERT, DELETE and UPDATE
        } catch (SQLException ex) {
            throw  new PersistenceException("Unable to add Product", ex);
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String SQL = "SELECT id, name, price FROM products";
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TRG", "root", "Welcome123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return products;
    }
}
