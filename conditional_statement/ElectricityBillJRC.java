import java.util.Scanner; // Import Scanner for user input

public class ElectricityBillJRC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input

        // Prompt the user to enter the number of units consumed
        System.out.print("Enter Your Number of Units Consumed: ");
        double unitConsumed = scanner.nextInt(); // Read the user's input as an integer

        // Calculate the total bill based on the number of units consumed
        if (unitConsumed == 100) {
            // If 100 units are consumed
            double totalAmountBill = 1.50 * unitConsumed; // Calculate the bill
            System.out.println("Your Total Amount Electricity Bill is: " + totalAmountBill);
        } else if (unitConsumed == 200) {
            // If 200 units are consumed
            double totalAmountBill = 2.50 * unitConsumed; // Calculate the bill
            System.out.println("Your Total Amount Electricity Bill is: " + totalAmountBill);
        } else {
            // For any other number of units consumed
            double totalAmountBill = 3.50 * unitConsumed; // Calculate the bill
            System.out.println("Your Total Amount Electricity Bill is: " + totalAmountBill);
        }

    }
}