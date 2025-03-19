import java.util.Scanner; // Import Scanner for user input

public class OddEvenJRC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // Read the user's input as an integer

        // Check if the number is even or odd
        if (num % 2 == 0) {
            // If the remainder when divided by 2 is 0, it's even
            System.out.println(num + " is an even number");
        } else {
            // If the remainder is not 0, it's odd
            System.out.println(num + " is an odd number");
        }

    }
}