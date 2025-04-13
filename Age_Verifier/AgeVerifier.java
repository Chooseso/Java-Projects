// Define a package named Age_Verifier (optional, but helpful for organization)
package Age_Verifier;

import java.util.Scanner; // Import the Scanner class for reading user input

// Main class to handle age verification logic
public class AgeVerifier {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read the age entered by the user

        try {
            // Call a method to check the age
            // This method may throw AgeRestrictionException
            checkAge(age);

            // If no exception is thrown, show success message
            System.out.println("Registration successful!");
        } catch (AgeRestrictionException e) {
            // This block runs if the user is under 18
            // Display the custom exception message
            System.out.println("Error: " + e.getMessage());
        }

    }

    // Method to check if the user meets the age requirement
    // If not, it throws a custom exception
    public static void checkAge(int age) throws AgeRestrictionException {
        if (age < 18) {
            // Throw the custom exception with a meaningful message
            throw new AgeRestrictionException("You must be at least 18 to register.");
        }
    }
}

// Custom exception class to handle age restrictions
// It extends Java's built-in Exception class
class AgeRestrictionException extends Exception {
    // Constructor that accepts a message and passes it to the base Exception class
    public AgeRestrictionException(String message) {
        super(message); // Call the superclass constructor to store the message
    }
}
