package com.pluralsight.finance;

public class CreditCard implements Valuable{

    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double charge(double amount){
        return balance + amount;
    }

    public double pay(double amount){
        return balance - amount;
    }

    @Override
    public double getValue(){
    return balance;
    }

    @Override
    public String toString() {
        return String.format("Credit Card Info:\n" +
                        "Name: %s\n" +
                        "Account Number: %s\n" +
                        "Balance: $%,.2f",
                name, accountNumber, balance);

    }
}
