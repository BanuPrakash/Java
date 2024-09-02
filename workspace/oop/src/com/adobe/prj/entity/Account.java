package com.adobe.prj.entity;

public class Account {
    private double balance; //state, instance variable; prefer making state as private

    // default constructor
    public  Account() {
        this.balance = 0.0;
    }
    // parametrized constructor
    public  Account(double init) {
        this.balance = init;
    }

    // actions / messages/ methods/ behaviour ---> public
    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }
}
