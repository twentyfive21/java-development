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

    @Override
    public String toString() {
        return String.format("BankAccount Info:\n" +
                        "Name: %s\n" +
                        "Account Number: %s\n" +
                        "Balance: $%,.2f",
                name, accountNumber, balance);

    }
}
