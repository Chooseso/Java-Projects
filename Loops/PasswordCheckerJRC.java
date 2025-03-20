import java.util.Scanner; // Import the Scanner class to get user input

public class PasswordCheckerJRC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        // Start a do-while loop to keep asking for the password
        do {
            System.out.print("Enter Password: "); // Prompt the user to enter a password
            String password = scanner.nextLine(); // Read the user's input as a string

            // Check if the entered password is correct
            if (password.equals("java123")) {
                System.out.println("Access granted!"); // Notify the user of successful access
                break; // Exit the loop since the password is correct
            } else {
                System.out.println("Incorrect Password. Try again."); // Inform the user that the password is incorrect
            }
        } while (true); // Repeat the loop indefinitely until the correct password is entered
    }
}