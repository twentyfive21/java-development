package com.pluralsight.finance;

public class BankAccount implements Valuable{

    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double deposit(double amount){
        return balance + amount;
    }

    public double withdraw(double amount){
        return balance - amount;
    }

    @Override
    public double getValue(){
        return balance;
    }
}
