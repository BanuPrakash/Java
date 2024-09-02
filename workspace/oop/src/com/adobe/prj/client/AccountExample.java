package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountExample {
    public static void main(String[] args) {
        Account rahulAcc = new Account(); // default constructor
        Account swethaAcc = new Account(5000); // parametrized constructor
        rahulAcc.deposit(4500);
        swethaAcc.deposit(3600);

        // use class context instead of object context
        // context.method()
        System.out.println(Account.getCount()); // 2 --> correct way
//        System.out.println(rahulAcc.getCount()); // 2 --> wrong way
//        System.out.println(swethaAcc.getCount()); // 2

        System.out.println("Rahul Acc : " + rahulAcc.getBalance());
        System.out.println("Swetha Acc : " + swethaAcc.getBalance());
    }
}