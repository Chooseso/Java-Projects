import java.util.Scanner; // Import Scanner for user input

public class SumofNumbersJRC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        int counter = 1; // Initialize counter for summation
        int sum = 0; // Initialize sum variable

        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt(); // Read user input

        // Check if the input is a positive integer
        if (num > 0) {
            // Calculate the sum of natural numbers from 1 to num
            while (counter <= num) {
                sum += counter; // Add counter to sum
                counter++; // Increment counter
            }
            // Display the final result after the loop
            System.out.println("The total sum of natural numbers from 1 to " + num + " is: " + sum);
        } else {
            // Handle invalid input
            System.out.println("Please enter a positive integer.");
        }

    }
}