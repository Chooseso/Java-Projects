import java.util.Scanner; // Import Scanner for user input
import java.util.Random;  // Import Random for generating random choices

public class RockPaperScissorJRC {
    public static void main(String[] args) {
        
        Random random = new Random(); // Create a Random object
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input

        // Array of computer choices: Rock, Paper, Scissors
        char[] computerChoices = {'R', 'P', 'S'};
        
        // Ask the user for their choice
        System.out.print("Enter your choice (R, P, S): ");
        String user = scanner.nextLine(); // Read user input

        // Get the first character from user input
        char userChoice = user.charAt(0);

        // Generate a random choice for the computer
        char computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        // Display the computer's choice
        System.out.println("Computer Choice: " + computerChoice);

        // Determine the winner using nested switch statements
        switch (userChoice) {
            case 'R': // User chose Rock
                switch (computerChoice) {
                    case 'R':
                        System.out.println("It's a tie"); // Both chose Rock
                        break;
                    case 'P':
                        System.out.println("Computer Wins"); // Computer chose Paper
                        break;
                    case 'S':
                        System.out.println("User Wins"); // Computer chose Scissors
                        break;
                }
                break;
            case 'P': // User chose Paper
                switch (computerChoice) {
                    case 'R':
                        System.out.println("User Wins"); // Computer chose Rock
                        break;
                    case 'P':
                        System.out.println("It's a tie"); // Both chose Paper
                        break;
                    case 'S':
                        System.out.println("Computer Wins"); // Computer chose Scissors
                        break;
                }
                break;
            case 'S': // User chose Scissors
                switch (computerChoice) {
                    case 'R':
                        System.out.println("Computer Wins"); // Computer chose Rock
                        break;
                    case 'P':
                        System.out.println("User Wins"); // Computer chose Paper
                        break;
                    case 'S':
                        System.out.println("It's a tie"); // Both chose Scissors
                        break;
                }
                break;
            default: // If the user input is invalid
                System.out.println("Invalid Input!"); // Inform the user
                break;
        }
    }
}