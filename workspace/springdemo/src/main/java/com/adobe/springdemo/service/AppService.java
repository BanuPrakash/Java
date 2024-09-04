package com.adobe.springdemo.service;

import com.adobe.springdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class AppService {
    @Autowired
    private EmployeeDao employeeDao; // interface loosely coupled

    @Autowired
    DataSource ds;
    public void insert() {
        try {
            Connection con = ds.getConnection(); // one connection from pool
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        employeeDao.addEmployee();
    }
}
