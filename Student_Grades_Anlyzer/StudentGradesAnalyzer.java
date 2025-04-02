package Student_Grades_Analyzer;

import java.util.Scanner;

public class StudentGradesAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user for the number of students in the class
        System.out.print("Enter the number of Students: ");
        int numberStudents = sc.nextInt();

        // Create an array to hold the grades of the students
        int[] students = new int[numberStudents];

        // Loop to get each student's grade
        for (int i = 0; i < students.length; i++) {
            int counter = 1 + i; // To display student numbers starting from 1

            // Prompt the user to enter the grade for each student
            System.out.print("Enter grade for student " + counter + ": ");
            int grade = sc.nextInt();
            students[i] = grade; // Store the grade in the array
        }

        // Initialize variables to find the highest and lowest grades
        int highestGrade = students[0]; // Start with the first grade as the highest
        int lowerGrade = students[0]; // Start with the first grade as the lowest
        double Average = 0; // This will hold the total of all grades

        // Loop through the grades to find the highest, lowest, and calculate the total
        for (int i = 0; i < students.length; i++) {
            // Check if the current grade is higher than the highest found so far
            if (highestGrade <= students[i]) {
                highestGrade = students[i];
            }
            // Check if the current grade is lower than the lowest found so far
            if (lowerGrade >= students[i]) {
                lowerGrade = students[i];
            }
            Average = Average + students[i]; // Add the current grade to the total
        }

        // Calculate the average by dividing the total by the number of students
        Average = Average / students.length;

        // Display the results to the user
        System.out.println("\nHighest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowerGrade);
        System.out.println("Average Grade: " + Average);
    }
}