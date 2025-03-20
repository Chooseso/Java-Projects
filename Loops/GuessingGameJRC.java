import java.util.Random; // Import the Random class to generate random numbers
import java.util.Scanner; // Import the Scanner class to get user input

public class GuessingGameJRC {
    public static void main(String[] args) {
        Random randomNumber = new Random(); // Create a Random object to generate random numbers
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        // Generate a random number between 0 and 49
        int guessRandomValue = randomNumber.nextInt(50);
        int attempt = 0; // Initialize a counter to track the number of attempts

        // Start an infinite loop to keep asking the user for guesses
        while (true) {
            System.out.print("Guess a number between 1 to 50: "); // Prompt the user to guess a number
            int userGuess = scanner.nextInt(); // Read the user's guess
            attempt++; // Increment the attempt counter

            // Check if the user's guess is correct
            if (userGuess == guessRandomValue) {
                System.out.println("Correct! You guessed it in " + attempt + " attempts."); // Notify the user of success
                break; // Exit the loop since the guess is correct
            } else {
                // Provide feedback based on the user's guess
                if (guessRandomValue > userGuess) {
                    System.out.println("Too low! Try again."); // Inform the user their guess was too low
                }
                if (guessRandomValue < userGuess) {
                    System.out.println("Too high! Try again."); // Inform the user their guess was too high
                }
            }
        }

    }
}