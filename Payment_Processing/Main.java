import java.util.Scanner;

// Interface defining the payment method
interface PaymentMethod {
    void processPayment(double amount); // Method to process payment
}

// Class representing Credit Card payment method
class CreditCard implements PaymentMethod {
    // Implement processPayment for CreditCard
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing credit card payment of $%.2f%n", amount);
    }
}

// Class representing PayPal payment method
class PayPal implements PaymentMethod {
    // Implement processPayment for PayPal
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing PayPal payment of $%.2f%n", amount);
    }
}

// Class representing Crypto Wallet payment method
class CryptoWallet implements PaymentMethod {
    // Implement processPayment for CryptoWallet
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing cryptocurrency payment of $%.2f%n", amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose payment method (1: Credit Card, 2: PayPal, 3: CryptoWallet): ");
        int choice = scanner.nextInt(); // Read user choice

        PaymentMethod paymentMethod; // Declare a variable of type PaymentMethod

        // Determine which payment method to use based on user input
        switch (choice) {
            case 1:
                paymentMethod = new CreditCard(); // CreditCard payment
                break;
            case 2:
                paymentMethod = new PayPal(); // PayPal payment
                break;
            case 3:
                paymentMethod = new CryptoWallet(); // CryptoWallet payment
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                scanner.close();
                return; // Exit the program if input is invalid
        }

        // Process a sample payment
        System.out.print("Enter the payment amount: ");
        double amount = scanner.nextDouble(); // Read payment amount
        paymentMethod.processPayment(amount); // Call the processPayment method
    }
}
