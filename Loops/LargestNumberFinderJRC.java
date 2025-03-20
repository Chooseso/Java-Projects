import java.util.ArrayList; // Import the ArrayList class to store a list of numbers
import java.util.Scanner; // Import the Scanner class to get user input

public class LargestNumberFinderJRC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        
        // Create an ArrayList to store the numbers entered by the user
        ArrayList<Integer> userInputNumber = new ArrayList<>();
        
        // Start an infinite loop to keep asking for user input
        while (true) {
            System.out.print("Enter a number (-1 to stop): "); // Prompt the user to enter a number
            int userInput = scanner.nextInt(); // Read the user's input

            // Check if the user wants to stop entering numbers
            if (userInput == -1) {
                // Check if the list is empty (no numbers were entered)
                if (userInputNumber.isEmpty()) {
                    System.out.println("Unable to find the max value, enter a number."); // Notify the user
                } else {
                    // Find the maximum number from the list
                    int max = userInputNumber.get(0); // Assume the first number is the largest
                    // Loop through the ArrayList to find the largest number
                    for (int i = 0; i < userInputNumber.size(); i++) {
                        // If the current number is larger than max, update max
                        if (userInputNumber.get(i) > max) {
                            max = userInputNumber.get(i);
                        }
                    }
                    // Print the largest number found
                    System.out.println("The largest number entered is: " + max);
                    break; // Exit the loop since we are done
                }
            } else {
                // Add the user's input number to the ArrayList
                userInputNumber.add(userInput);
            }
        }
        
    }
}