/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptg;

/**
 *
 * @author abqary1907
 */

// Subclass 2: Current Account (Checking Account)
class CurrentAccount extends Account {
    // Constraint: At least 3 attributes
    private double overdraftLimit;
    private double transactionFee;
    private double overdraftUsed;

    public CurrentAccount(String id, String name, double balance, double overdraftLimit) {
        super(id, name, balance);
        this.overdraftLimit = overdraftLimit;
        this.transactionFee = 2.50; // Flat fee for using overdraft
        this.overdraftUsed = 0.0;
    }

    // Override: Allow withdrawal beyond 0 up to overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            
            // Check if we are using overdraft
            if (balance < 0) {
                overdraftUsed = Math.abs(balance);
                System.out.println("Warning: Overdraft used. Current used: $" + overdraftUsed);
            }
            System.out.println(accountHolder + " withdrew: $" + amount + " (Current Account)");
        } else {
            System.out.println("Transaction declined. Exceeds overdraft limit.");
        }
    }

    // Override: Current accounts usually do not earn interest
    @Override
    public double calculateInterest() {
        return 0.0;
    }

    // Unique method 1: Apply transaction fee if overdraft is used
    public void chargeOverdraftFee() {
        if (balance < 0) {
            balance -= transactionFee;
            System.out.println("Overdraft fee of $" + transactionFee + " charged.");
        }
    }

    // Unique method 2: Reset overdraft usage (e.g., after deposit)
    public void checkOverdraftStatus() {
        if (balance >= 0) {
            overdraftUsed = 0;
            System.out.println("Account is in good standing.");
        } else {
            System.out.println("Account is currently overdrawn.");
        }
    }
}