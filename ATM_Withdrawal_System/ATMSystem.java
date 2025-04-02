package ATM_Withdrawal_System;

import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {
        // Array to hold the balances of 5 accounts, all starting with a balance of 0
        int[] accountsBalances = { 0, 0, 0, 0, 0 };
        Scanner sc = new Scanner(System.in);

        // Start an infinite loop to allow continuous transactions
        while (true) {
            // Show available accounts to the user
            System.out.println("Available Accounts:");
            for (int i = 1; i <= accountsBalances.length; i++) {
                System.out.println("Account " + i); // Display account number
            }

            // Prompt the user to enter the account number they want to access
            System.out.print("\nEnter Account: ");
            int account = sc.nextInt();
            account = account - 1; // Adjust for zero-based index

            // Display the current balance of the selected account
            System.out.println("Current Balance: " + accountsBalances[account]);

            // Ask the user for the type of transaction (withdraw or deposit)
            System.out.print("Enter Transaction type (1-Withdraw, 2-Deposit): ");
            int transaction = sc.nextInt();

            // Handle withdrawal transactions
            if (transaction == 1) {
                System.out.print("Enter Amount to Withdraw: ");
                int withdrawAmount = sc.nextInt();

                // Check if there is enough balance for the withdrawal
                if (withdrawAmount > accountsBalances[account]) {
                    System.out.println("\nInsufficient Balance"); // Notify if balance is too low
                } else {
                    // Deduct the amount from the account balance
                    accountsBalances[account] = accountsBalances[account] - withdrawAmount;
                    System.out.println("\nTransaction Successful!");
                    System.out.println("New Balance: " + accountsBalances[account] + "\n");
                }
            }
            // Handle deposit transactions
            if (transaction == 2) {
                System.out.print("Enter Amount to Deposit: ");
                int deposit = sc.nextInt();

                // Check if the deposit amount is valid
                if (deposit <= 0) {
                    System.out.println("\nPlease enter at least 1 or more!");
                } else {
                    // Add the deposit amount to the account balance
                    accountsBalances[account] = accountsBalances[account] + deposit;
                    System.out.println("\nTransaction Successful!");
                    System.out.println("New Balance: " + accountsBalances[account] + "\n");
                }
            }
        }
    }
}