package student_Grade_Management_System;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> studentName = new ArrayList<>();
        ArrayList<Double> studnetGrade = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Grade");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("\nEnter you choice: ");
            int choice = sc.nextInt();

            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Student name: ");
                String name = sc.nextLine();
                System.out.print("Enter Student grade: ");
                double grade = sc.nextDouble();
                sc.nextLine();
                studentName.add(name);
                studnetGrade.add(grade);
                System.out.println("Student Added!\n");
            } else if (choice == 2) {
                System.out.println("Student List:");
                for (int i = 0; i < studentName.size(); i++) {
                    System.out.println(studentName.get(i) + " = " + studnetGrade.get(i));
                }
                System.out.println();
            } else if (choice == 3) {
                System.out.print("Enter student name: ");
                String retrieveName = sc.nextLine();

                for (int i = 0; i < studentName.size(); i++) {
                    if (retrieveName.equals(studentName.get(i))) {
                        System.out.print("Enter new grade: ");
                        double newGrade = sc.nextDouble();
                        studnetGrade.set(i, newGrade);
                        System.out.println("Grade is now updated!\n");
                    }

                }
            } else if (choice == 4) {
                System.out.print("Enter student name to remove: ");
                String removeStudent = sc.nextLine();

                for (int i = 0; i < studentName.size(); i++) {
                    if (removeStudent.equals(studentName.get(i))) {
                        studentName.remove(i);
                        System.out.println("Student removed!\n");
                        continue;
                    }
                }
            } else {
                System.out.println("Exiting...........");
                break;
            }

        }

    }
}
