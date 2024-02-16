package modules;

import exceptions.IllegalArgumentException;
import exceptions.InsufficientFundsException;

// Account class
// This class is used to create an account object with a customer and balance
// It also contains methods to deposit, withdraw, and display the balance
public class Account {
    private String accountId;
    private Customer customer;
    private double balance;

    public Account(String accountId, Customer customer, double initialBalance) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountId() {
        return accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit and Withdraw methods with Exception Handling
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        this.balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0 || amount > balance) {
            throw new InsufficientFundsException("Invalid withdrawal amount or insufficient funds");
        }
        this.balance -= amount;
        System.out.println("Withdrawal successful. New balance: $" + balance);
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Account balance: $" + balance);
    }
}
