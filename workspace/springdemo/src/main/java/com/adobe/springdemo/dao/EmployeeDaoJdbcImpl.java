package com.adobe.springdemo.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoJdbcImpl implements  EmployeeDao{
    @Override
    public void addEmployee() {
        System.out.println("Stored in database!!!");
    }
}



