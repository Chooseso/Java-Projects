import java.util.Scanner;
import java.util.ArrayList;

public class StudentGradesAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> studentsGrades = new ArrayList<>();
        double totalGrades = 0;
        double averageGrades = 0;
        double highestGrade = 0;
        double lowestGrade = 0;

        // Ask the user for the number of students
        System.out.print("Enter Number of Students: ");
        double numberStudent = scanner.nextInt();
        System.out.println();

        // Collect grades for each student
        for (int i = 1; i <= numberStudent; i++) {
            System.out.print("Enter grade for student " + i + ": ");
            double grades = scanner.nextDouble();
            studentsGrades.add(grades);
        }

        System.out.println("=== Grade Analysis ===");
        // Calculate total, average, highest, and lowest grades
        for (double grade : studentsGrades) {
            totalGrades = totalGrades + grade;
            averageGrades = totalGrades / numberStudent;

            // Update highest grade if the current grade is higher
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            // Update lowest grade if the current grade is lower
            if (lowestGrade == 0 || grade < lowestGrade) {
                lowestGrade = grade; // Initialize lowestGrade on first run
            }
        }

        // Display the results
        System.out.println("Total Grades: " + totalGrades);
        System.out.println("Average Grade: " + averageGrades);
        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
    }
}