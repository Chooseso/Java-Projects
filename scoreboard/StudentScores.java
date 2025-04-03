
package scoreboard;

import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt for the number of students and subjects
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        // Create a 2D array to store scores
        int[][] scores = new int[numStudents][numSubjects];

        // Collect scores for each student
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter scores for Student " + (i + 1) + ": ");
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = sc.nextInt(); // Read each score
            }
        }

        // Calculate and display total and average scores for each student
        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < numSubjects; j++) {
                total += scores[i][j]; // Accumulate total score
            }
            double average = (double) total / numSubjects; // Calculate average

            // Display results
            System.out.printf("Student %d - Total: %d, Average: %.2f%n", (i + 1), total, average);
        }


    }
}
