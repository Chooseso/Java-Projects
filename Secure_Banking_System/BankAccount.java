package Secure_Banking_System;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    // Private fields to store account details
    private String accountNumber; // Account number (should be 10 digits)
    private String accountHolder; // Name of the account holder
    private double balance; // Current balance in the account
    ArrayList<String> conductedTransation = new ArrayList<>(); // List to track transaction types
    private ArrayList<String> transactionHistory = new ArrayList<>(); // List to track transaction amounts
    private double interestRate; // Interest rate for the account

    // Getter for account number
    public String getAccounNumber() {
        return accountNumber;
    }

    // Setter for account number with validation
    public void setAccountNumber(String accountNumber) {
        if (accountNumber.length() == 10) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Invalid!! Account number should consist of 10 digits");
        }
    }

    // Getter for account holder name
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter for account holder name with validation
    public void setAccountHolder(String accountHolder) {
        if (accountHolder.isEmpty()) {
            System.out.println("Account Holder Should Contain Name!!");
        } else {
            this.accountHolder = accountHolder;
        }
    }

    // Getter for current balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance with validation
    public void setBalance(double balance) {
        if (balance > -1) {
            this.balance = balance;
        } else {
            System.out.println("Balance Should not have negative value!!");
        }
    }

    // Method to view account details
    public void viewAccountDetails() {
        System.out.println("\n---- Account Details ----\n");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolder);
        System.out.println("Account Balance: " + "$" + this.balance);
    }

    // Method to deposit money into the account
    public void deposit() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter deposit amount: ");
            double deposit = sc.nextDouble();
            if (deposit != 0) {
                this.transactionHistory.add(Double.toString(deposit));
                this.balance = this.balance + deposit;
                System.out.println("Deposit successful. New balance: " + "$" + this.balance);
                System.out.println("Transaction Recorded: " + "Deposit " + "$" + deposit);
                break;
            } else {
                System.out.println("Enter valid amount of deposit (greater than 0)!");
            }
        }
    }

    // Method to withdraw money from the account
    public void withdraw() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Withdrawal Amount: ");
            double withdraw = sc.nextDouble();

            if (withdraw > this.balance) {
                System.out.println("Insufficient Funds!");
            } else if (withdraw == 0) {
                System.out.println("Enter valid withdrawal amount (greater than 0)!");
            } else {
                this.balance = this.balance - withdraw;
                this.transactionHistory.add(Double.toString(withdraw));
                System.out.println("Withdrawal Successful!");
                break;
            }
        }
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Method to calculate and apply interest to the balance
    public void calculateInterestRate() {
        double interestrate = this.interestRate;
        interestrate = interestrate / 100; // Convert percentage to decimal
        interestrate = this.balance * interestrate; // Calculate interest
        this.balance = this.balance + interestrate; // Update balance with interest
        this.transactionHistory.add(Double.toString(this.balance)); // Record the new balance
        System.out.println("Interest Applied. New balance: " + "$" + this.balance + " (Interest Rate: 5% annual)");
    }

    // Method to view transaction history
    public void TransactionHistory() {
        System.out.println("--- Transaction History ---\n");
        for (int i = 0; i < this.transactionHistory.size(); i++) {
            System.out.println("-" + this.conductedTransation.get(i) + ": " + this.transactionHistory.get(i));
        }
    }

    // Main method to run the banking application
    public static void main(String[] args) {
        BankAccount bankaccount = new BankAccount();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Welcome to the Secure Banking System === \n");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Interest");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer

            if (choice == 1) {
                // Prompt for account number
                while (true) {
                    System.out.print("\nEnter Account Number (10 digits): ");
                    String accountNumber = sc.nextLine();

                    if (accountNumber.length() == 10) {
                        bankaccount.setAccountNumber(accountNumber);
                        break;
                    } else {
                        bankaccount.setAccountNumber(accountNumber);
                    }
                }

                // Prompt for account holder name
                while (true) {
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = sc.nextLine();
                    if (accountHolderName.isEmpty()) {
                        bankaccount.setAccountHolder(accountHolderName);
                    } else {
                        bankaccount.setAccountHolder(accountHolderName);
                        break;
                    }
                }

                // Prompt for initial deposit
                while (true) {
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposits = sc.nextDouble();
                    if (initialDeposits > -1) {
                        bankaccount.setBalance(initialDeposits);
                        break;
                    } else {
                        bankaccount.setBalance(initialDeposits);
                    }
                }
                System.out.println("*** Account created Successfully ***\n");

            } else if (choice == 2) {
                // View account details
                bankaccount.viewAccountDetails();
            } else if (choice == 3) {
                // Deposit money
                bankaccount.conductedTransation.add("Deposit");
                bankaccount.deposit();
            } else if (choice == 4) {
                // Withdraw money
                bankaccount.conductedTransation.add("Withdrew");
                bankaccount.withdraw();
            } else if (choice == 5) {
                // Apply interest
                bankaccount.conductedTransation.add("Applied Interest");
                bankaccount.setInterestRate(5); // Set interest rate to 5%
                bankaccount.calculateInterestRate();
            } else if (choice == 6) {
                // View transaction history
                bankaccount.TransactionHistory();
            } else {
                // Exit the program
                System.out.println("Thank you for using the Secure Banking System. Goodbye!");
                break;
            }
        }
    }
}