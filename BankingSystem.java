/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ptg;

public class BankingSystem {
    public static void main(String[] args) {

        // 1. Create a Savings Account
        // Attributes: ID, Name, Balance, Interest Rate (5%), Min Balance ($100)
        SavingsAccount mySavings = new SavingsAccount("SA001", "Alice", 500.0, 5.0, 100.0);
        
        mySavings.displayInfo();
        mySavings.deposit(200.0);
        
        // Test validation: Try to withdraw too much (leaving less than min balance)
        System.out.println("\n-> Attempting to withdraw $550 (Resulting balance $150 > Min $100):");
        mySavings.withdraw(550.0); 
        
        System.out.println("\n-> Attempting to withdraw $100 (Resulting balance $50 < Min $100):");
        mySavings.withdraw(100.0); // Should fail

        // Test interest calculation
        System.out.println("\n-> Applying Monthly Interest:");
        mySavings.addInterestToBalance();
        mySavings.displayInfo();

        System.out.println("\n------------------------------------------------");

        // 2. Create a Current Account
        // Attributes: ID, Name, Balance, Overdraft Limit ($500)
        CurrentAccount myCurrent = new CurrentAccount("CA002", "Bob", 200.0, 500.0);
        
        myCurrent.displayInfo();
        
        // Test validation: Withdraw more than balance but within overdraft
        System.out.println("\n-> Attempting to withdraw $600 (Uses overdraft):");
        myCurrent.withdraw(600.0); // Balance becomes -400
        
        // Test validation: Withdraw beyond overdraft
        System.out.println("\n-> Attempting to withdraw $200 more (Exceeds limit):");
        myCurrent.withdraw(200.0); // Should fail (-400 - 200 = -600, limit is 500)

        // Test fee logic
        myCurrent.chargeOverdraftFee();
        myCurrent.checkOverdraftStatus();
        
        myCurrent.displayInfo();
    }
}