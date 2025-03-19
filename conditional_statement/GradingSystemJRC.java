import java.util.Scanner; // Import Scanner for user input

public class GradingSystemJRC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input

        // Prompt the user to enter their score
        System.out.print("Enter Your Score: ");
        int score = scanner.nextInt(); // Read the user's input as an integer

        // Determine the grade based on the score
        if (score >= 90) {
            // Score of 90 or above
            System.out.println("You got an A grade, excellent!");
        } else if (score >= 75 && score <= 89) {
            // Score between 75 and 89
            System.out.println("You got a B grade, very good!");
        } else if (score >= 50 && score <= 74) {
            // Score between 50 and 74
            System.out.println("You got a C grade, good!");
        } else {
            // Score below 50
            System.out.println("You got an F grade, do your best next time!");
        }
    }
}