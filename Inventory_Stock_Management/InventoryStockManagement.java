import java.util.Arrays;
import java.util.Scanner;

public class InventoryStockManagement {

    public static void main(String[] args) {
        // Initial stock levels for products
        int[] stock = { 10, 25, 14, 30, 5, 18, 22, 40, 12, 8 };

        // Variables to track the highest and lowest stock levels
        int highestStock = stock[0];
        int lowestStock = stock[0];

        Scanner sc = new Scanner(System.in);

        // Start of the main menu loop
        while (true) {
            // Welcome message and menu options
            System.out.println("\n=== Welcome to Inventory Stock Management System ===\n");
            System.out.println("1. View stock of all products");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Product Stock Highest and Lowest");
            System.out.println("4. Exit");

            // Prompt the user to enter their choice
            System.out.print("\nEnter Choice: ");
            int choice = sc.nextInt();

            // Option 1: View current stock levels
            if (choice == 1) {
                System.out.println("Current Stock Levels: \n" + Arrays.toString(stock));
            }
            // Option 2: Update stock for a specific product
            else if (choice == 2) {
                System.out.print("Enter Product Position Number: ");
                int index = sc.nextInt(); // Get the product position from the user

                index = index - 1; // Adjust for zero-based index

                System.out.print("Enter the new product stock value: ");
                int newStock = sc.nextInt(); // Get the new stock value

                stock[index] = newStock; // Update the stock array

                // Show updated stock levels
                System.out.println("\nUpdated Stock Levels: \n" + Arrays.toString(stock));
            }
            // Option 3: Display highest and lowest stock levels
            else if (choice == 3) {
                // Loop through the stock to find highest and lowest values
                for (int i = 0; i < stock.length; i++) {
                    if (highestStock <= stock[i]) {
                        highestStock = stock[i]; // Update highest stock
                    }
                    if (lowestStock >= stock[i]) {
                        lowestStock = stock[i]; // Update lowest stock
                    }
                }

                // Display the results
                System.out.println("Highest Stock: " + highestStock);
                System.out.println("Lowest Stock: " + lowestStock);
            }
            // Option 4: Exit the program
            else {
                System.out.println("Exiting.........");
                break; // Break the loop to exit
            }
        }
    }
}