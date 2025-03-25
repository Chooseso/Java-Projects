import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    // Class variables to store student information
    String name;
    String id;
    double grade;
    
    // Lists to hold student names, IDs, and grades
    ArrayList<String> studentsNames = new ArrayList<>();
    ArrayList<Double> studentsGrades = new ArrayList<>();
    ArrayList<String> studentsId = new ArrayList<>();

    // Method to add a student's name
    public ArrayList<String> addStudentName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Student Name: ");
        this.name = sc.nextLine(); // Get the student name from user input
        this.studentsNames.add(name); // Add the name to the list
        return studentsNames; // Return the list of names
    }

    // Method to add a student's ID
    public ArrayList<String> addStudentID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        this.id = sc.nextLine(); // Get the student ID from user input
        this.studentsId.add(id); // Add the ID to the list
        return studentsId; // Return the list of IDs
    }

    // Method to add a student's grade
    public ArrayList<Double> addStudentGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Grade: ");
        this.grade = sc.nextDouble(); // Get the student grade from user input
        this.studentsGrades.add(grade); // Add the grade to the list
        return studentsGrades; // Return the list of grades
    }

    // Method to view all students and their details
    public void viewAllStudents() {
        System.out.println("\n--- Student Record ---\n");
        for (int i = 0; i < this.studentsNames.size(); i++) {
            // Display each student's information
            int addedStudents = 1 + i; // Student number starts from 1
            System.out.println("Student Number: " + addedStudents);
            System.out.println("Student Name: " + this.studentsNames.get(i));
            System.out.println("Student ID: " + this.studentsId.get(i));
            System.out.println("Student Grade: " + this.studentsGrades.get(i));
            System.out.println("\n------------------------------------------\n");
        }
    }

    // Method to update a student's grade
    public ArrayList<Double> updateStudentGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to update grades: ");
        String searchId = sc.nextLine(); // Get the ID of the student to update

        for (int i = 0; i < this.studentsId.size(); i++) {
            // Find the student by ID
            if (this.studentsId.get(i).equals(searchId)) {
                System.out.print("Enter Updated Student Grade: ");
                double updateGrade = sc.nextDouble(); // Get the new grade
                this.studentsGrades.set(i, updateGrade); // Update the grade in the list
                System.out.println("*** You Have Successfully Updated Grade of " + this.studentsNames.get(i) + " ***");
                break; // Exit the loop after updating
            }
        }
        return studentsGrades; // Return the updated list of grades
    }

    // Main method to run the program
    public static void main(String[] args) {
        StudentManagementSystem obj = new StudentManagementSystem(); // Create an instance of the system
        Scanner sc = new Scanner(System.in);
        
        while (true) { // Loop to keep the program running
            System.out.println("\n=== Welcome to the Student Management System ===\n");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Exit\n\n");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt(); // Get the user's choice

            // Process the user's choice
            if (choice == 1) {
                obj.addStudentName(); // Add a student's name
                obj.addStudentID(); // Add a student's ID
                obj.addStudentGrade(); // Add a student's grade
                System.out.println("** Student Added Successfully! **\n");
            } else if (choice == 2) {
                obj.viewAllStudents(); // View all students
            } else if (choice == 3) {
                obj.updateStudentGrade(); // Update a student's grade
            } else {
                System.out.println("Exiting Program .....");
                break; // Exit the program
            }
        }
    }
}