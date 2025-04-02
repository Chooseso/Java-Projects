package Student_Grades_Anlyzer;

import java.util.Scanner;

public class StudentGradesAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Students: ");
        int numberStudents = sc.nextInt();

        int[] students = new int[numberStudents];

        for (int i = 0; i < students.length; i++) {
            int counter = 1 + i;

            System.out.print("Enter grade for student " + counter + ": ");
            int grade = sc.nextInt();
            students[i] = grade;

        }

        int highestGrade = students[0];
        int lowerGrade = students[0];
        double Average = 0;

        for (int i = 0; i < students.length; i++) {
            if (highestGrade <= students[i]) {
                highestGrade = students[i];
            }
            if (lowerGrade >= students[i]) {
                lowerGrade = students[i];
            }
            Average = Average + students[i];
        }

        Average = Average / students.length;

        System.out.println("\nHighest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowerGrade);
        System.out.println("Average Grade: " + Average);

    }

}
