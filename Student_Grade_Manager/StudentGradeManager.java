import java.util.Scanner;

public class StudentGradeManager {
    // Instance variables to hold student details
    private String name;
    private double[] grades;

    // Constructor to initialize student name and grades
    public StudentGradeManager(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    // Method to calculate the average of grades
    public double calculateAverage() {
        double total = 0;
        for (double grade : grades) {
            total += grade; // Sum all grades
        }
        return total / grades.length; // Return average
    }

    // Method to classify the average grade
    public String classifyGrade(double average) {
        if (average >= 90) {
            return "Excellent"; // Grade classification for 90-100
        } else if (average >= 80) {
            return "Good"; // Grade classification for 80-89
        } else if (average >= 70) {
            return "Average"; // Grade classification for 70-79
        } else {
            return "Needs Improvement"; // Grade classification below 70
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        double average = calculateAverage(); // Calculate average grade
        String classification = classifyGrade(average); // Classify average grade

        // Print student details
        System.out.println("Student: " + name);
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + ", "); // Print each grade
        }
        System.out.printf("\nAverage: %.2f\n", average); // Print average with 2 decimal points
        System.out.println("Classification: " + classification); // Print classification
    }

    // Overloaded method to handle four grades
    public static double calculateAverage(double grade1, double grade2, double grade3, double grade4) {
        return (grade1 + grade2 + grade3 + grade4) / 4; // Calculate average for four grades
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner for user input

        // Adding a student with three grades
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine(); // Get student name

        double[] grades = new double[3]; // Array to hold three grades
        System.out.print("Enter 3 grades: ");
        for (int i = 0; i < 3; i++) {
            grades[i] = scanner.nextDouble(); // Get grades from user
        }

        StudentGradeManager student = new StudentGradeManager(studentName, grades); // Create student object
        student.displayStudentDetails(); // Display student details

        // Adding a student with four grades
        System.out.print("\nEnter student name: ");
        scanner.nextLine(); // Consume newline
        studentName = scanner.nextLine(); // Get student name

        double[] fourGrades = new double[4]; // Array to hold four grades
        System.out.print("Enter 4 grades: ");
        for (int i = 0; i < 4; i++) {
            fourGrades[i] = scanner.nextDouble(); // Get grades from user
        }

        StudentGradeManager student2 = new StudentGradeManager(studentName, fourGrades); // Create second student object
        student2.displayStudentDetails(); // Display second student details

        // Calculate and display average for four grades using the overloaded method
        double averageFourGrades = calculateAverage(fourGrades[0], fourGrades[1], fourGrades[2], fourGrades[3]);
        System.out.printf("Average for 4 grades: %.2f\n", averageFourGrades);
    }
}