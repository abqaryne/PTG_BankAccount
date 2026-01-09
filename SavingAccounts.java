/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptg;

/**
 *
 * @author abqary1907
 */
// Subclass 1: Savings Account
class SavingsAccount extends Account {
    // Constraint: At least 3 attributes
    private double interestRate;
    private double minimumBalance;
    private double totalInterestEarned;

    public SavingsAccount(String id, String name, double balance, double rate, double minBal) {
        super(id, name, balance); // Calls the parent constructor
        this.interestRate = rate;
        this.minimumBalance = minBal;
        this.totalInterestEarned = 0.0;
    }

    // Override: Validate withdrawal against minimum balance logic
    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Transaction failed. Balance cannot fall below $" + minimumBalance);
        } else {
            super.withdraw(amount); // Use parent logic for the actual deduction
        }
    }

    // Override: Calculate monthly interest based on rate
    @Override
    public double calculateInterest() {
        double monthlyInterest = balance * (interestRate / 100);
        totalInterestEarned += monthlyInterest;
        return monthlyInterest;
    }

    // Unique method 1: Apply interest to balance
    public void addInterestToBalance() {
        double interest = calculateInterest();
        if (interest > 0) {
            balance += interest;
            System.out.println("Interest added: $" + interest);
        }
    }
    
    // Unique method 2: Check status
    public boolean isAccountActive() {
        return balance > minimumBalance;
    }
}