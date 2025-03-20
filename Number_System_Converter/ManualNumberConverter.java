import java.util.Scanner; // Import the Scanner class to read user input

public class ManualNumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt the user to enter a decimal number
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt(); // Read the decimal number

        // Convert the decimal number to binary
        String binary = convertToBinary(decimalNumber);
        // Convert the decimal number to octal
        String octal = convertToOctal(decimalNumber);
        // Convert the decimal number to hexadecimal
        String hexadecimal = convertToHexadecimal(decimalNumber);
        
        // Display the results
        System.out.println("=== Number System Conversion ===");
        System.out.printf("Binary: %s%n", binary);
        System.out.printf("Octal: %s%n", octal);
        System.out.printf("Hexadecimal: %s%n", hexadecimal);
        
    }

    // Method to convert decimal to binary
    public static String convertToBinary(int decimal) {
        StringBuilder covertToBinary = new StringBuilder(); // Use StringBuilder for efficient string manipulation
        while (decimal > 0) {
            covertToBinary.insert(0, decimal % 2); // Prepend the binary digit
            decimal /= 2; // Divide by 2 to get the next digit
        }
        return covertToBinary.toString(); // Return the binary string
    }

    // Method to convert decimal to octal
    public static String convertToOctal(int decimal) {
        StringBuilder convertToOctal = new StringBuilder(); // Use StringBuilder for efficient string manipulation
        while (decimal > 0) {
            convertToOctal.insert(0, decimal % 8); // Prepend the octal digit
            decimal /= 8; // Divide by 8 to get the next digit
        }
        return convertToOctal.toString(); // Return the octal string
    }

    // Method to convert decimal to hexadecimal
    public static String convertToHexadecimal(int decimal) {
        StringBuilder convertToHexadecimal = new StringBuilder(); // Use StringBuilder for efficient string manipulation
        while (decimal > 0) {
            int remainder = decimal % 16; // Get the remainder
            // Convert to hexadecimal character
            if (remainder < 10) {
                convertToHexadecimal.insert(0, remainder); // For 0-9, just add the number
            } else {
                convertToHexadecimal.insert(0, (char) ('A' + (remainder - 10))); // For 10-15, convert to A-F
            }
            decimal /= 16; // Divide by 16 to get the next digit
        }
        return convertToHexadecimal.toString(); // Return the hexadecimal string
    }
}