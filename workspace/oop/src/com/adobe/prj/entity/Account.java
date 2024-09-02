package com.adobe.prj.entity;

public class Account {
    private double balance; //state, instance variable; prefer making state as private
    private static int count; // state of class
    // default constructor
    public  Account() {
        this.balance = 0.0;
        count++;
    }
    // parametrized constructor
    public  Account(double init) {
        this.balance = init;
        count++;
    }

    // actions / messages/ methods/ behaviour ---> public
    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }

    // class method
    public static int getCount() {
        return  count;
    }
}
