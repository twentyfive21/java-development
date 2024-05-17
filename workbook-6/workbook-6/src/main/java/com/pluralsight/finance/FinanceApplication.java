package com.pluralsight.finance;

import com.pluralsight.portfolio.Portfolio;

public class FinanceApplication {

    public static void main(String[] args) {
        // Account Instantiation: Here, account1 is a BankAccount object.
        // account1 is instantiated as a BankAccount object using the constructor of the BankAccount class:
        BankAccount account1 = new BankAccount("Pam", "123",  12500);
        // interfaces cannot be instantiated they must be implemented by classes for acc 2
        // interfaces do not have data members
        // all methods must be public and no code within the interface. all methods are abstract


        // Polymorphic Instantiation:
        // account2 is instantiated in a polymorphic way.
        // It's declared as type Valuable and initialized as a BankAccount object:
        Valuable account2 = new BankAccount( "Gary","456", 1500);
        // try to deposit money into both accounts
        account1.deposit(100);
        account1.withdraw(50);
        account1.getValue();

        /* Here, account2 is of type Valuable, which is an interface.
             However, it's referencing a BankAccount object because BankAccount
             implements the Valuable interface. acc 2 only has get value
             method bc Valuable interface only has that method */

        // account2.deposit(100); an error since cannot access that method
        account2.getValue();

    /* Polymorphism in Action:
    - Both account1 and account2 are instances of the BankAccount class,
        but they are referenced differently.
    - account1 is directly referenced as a BankAccount object,
         so you can directly access all methods and properties defined in the BankAccount class.
    - account2 is referenced as a Valuable type, which means you can only access methods
         defined in the Valuable interface through it.
    - This is a form of polymorphism, where the same method call
         (getValue()) behaves differently depending on the actual object it's referring to.

    - In summary, account2 is indeed instantiated as a BankAccount object,
        but it's referenced as a Valuable type due to polymorphism,
        allowing you to treat it as a Valuable object.
     */

    }
}
