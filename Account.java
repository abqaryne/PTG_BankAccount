/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ptg;

public class Account {
    // Constraint: At least 3 attributes
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    // Constraint: Constructor
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Base method for depositing money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Constraint: At least one overridden method (this is the base version)
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Base method for interest (returns 0 by default)
    public double calculateInterest() {
        return 0.0;
    }

    // Helper method to show details
    public void displayInfo() {
        System.out.println("\nAccount Details: ");
        System.out.println("ID: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}