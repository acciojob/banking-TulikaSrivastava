package com.driver;

public class Main {
    public static void main(String[] args) {

        try {
            // Create a SavingsAccount object
            SavingsAccount savingsAccount = new SavingsAccount("John Doe", 5000.0, 2000.0, 0.05);
            savingsAccount.deposit(1000.0);
            savingsAccount.withdraw(300.0);
            double savingsInterest = savingsAccount.getSimpleInterest(3);
            System.out.println("Savings Account Balance with Interest: " + savingsInterest);

            // Create a CurrentAccount object
            CurrentAccount currentAccount = new CurrentAccount("Jane Smith", 10000.0, "ABC123");
            currentAccount.deposit(2000.0);
            currentAccount.withdraw(5000.0);
            currentAccount.validateLicenseId();

            // Create a StudentAccount object
            StudentAccount studentAccount = new StudentAccount("Alice Johnson", 500.0, "XYZ University");
            studentAccount.deposit(100.0);
            studentAccount.withdraw(50.0);

            // Generate account numbers
            String accountNumber1 = savingsAccount.generateAccountNumber(8, 24);
            String accountNumber2 = currentAccount.generateAccountNumber(6, 15);
            String accountNumber3 = studentAccount.generateAccountNumber(7, 18);

            System.out.println("Account Number 1: " + accountNumber1);
            System.out.println("Account Number 2: " + accountNumber2);
            System.out.println("Account Number 3: " + accountNumber3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}