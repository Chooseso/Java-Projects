package Employee_Payroll_Management_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    // Attributes of the Employee
    String name;
    int employeeID;
    double salary;
    String department;

    // Default constructor with default values
    Employee() {
        this.name = "Unknown";
        this.employeeID = 0;
        this.salary = 0;
        this.department = "Unknown";
    }

    // Parameterized constructor to set values from user input
    Employee(String name, int employeeID, double salary, String department) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
        this.department = department;
    }

    // Method to display all employee records
    public void displayInfo(ArrayList<String> employeesName, ArrayList<Integer> employeesID,
            ArrayList<Double> employeesSalary, ArrayList<String> employeesDepartment) {
        System.out.println("\n--- Employee's Records ---\n");
        for (int i = 0; i < employeesName.size(); i++) {
            int numberOfEmployees = 1 + i; // Employee number starts from 1
            System.out.println("Employee: " + numberOfEmployees);
            System.out.println("Name: " + employeesName.get(i)); // Display name
            System.out.println("ID: " + employeesID.get(i)); // Display ID
            System.out.println("Salary: " + "$" + employeesSalary.get(i)); // Display salary
            System.out.println("Department: " + employeesDepartment.get(i)); // Display department
            System.out.println("\n----------------------------------------\n");
        }
    }

    // Method to calculate the annual salary of an employee
    public void CalculateAnnualSalary(ArrayList<Integer> employeesID, ArrayList<Double> employeesSalary,
            ArrayList<String> employeesName) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee's ID to calculate salary: ");
        int id = sc.nextInt(); // Get employee ID from user

        // Search for the employee by ID
        for (int i = 0; i < employeesID.size(); i++) {
            if (id == employeesID.get(i)) {
                double calculatedSalary = employeesSalary.get(i) * 12; // Calculate annual salary
                System.out.println("Annual Salary of " + employeesName.get(i) + ": " + "$" + calculatedSalary);
                System.out.println("*** Successfully Calculated the Annual Salary ***");
                break; // Exit loop after finding the employee
            }
        }
    }

    // Method to raise an employee's salary by a percentage
    public ArrayList<Double> raiseSalary(double percentage, ArrayList<Double> employeesSalary,
            ArrayList<Integer> employeesID, ArrayList<String> employeesName) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID to raise salary: ");
        int id = sc.nextInt(); // Get employee ID from user

        // Search for the employee by ID
        for (int i = 0; i < employeesSalary.size(); i++) {
            if (id == employeesID.get(i)) {
                System.out.print("Enter Percentage Increase: ");
                double percentageValue = sc.nextDouble(); // Get percentage increase
                percentage = percentageValue / 100; // Convert to decimal

                // Calculate new salary
                double newSalary = (employeesSalary.get(i) * percentage) + employeesSalary.get(i);
                employeesSalary.set(i, newSalary); // Update the salary in the list

                System.out.println("Salary Updated Successfully! New Salary: " + "$" + newSalary);
                break; // Exit loop after updating salary
            }
        }

        return employeesSalary; // Return updated salary list
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Lists to store employee details
        ArrayList<String> employeesName = new ArrayList<>();
        ArrayList<Integer> employeesID = new ArrayList<>();
        ArrayList<Double> employeesSalary = new ArrayList<>();
        ArrayList<String> employeesDepartment = new ArrayList<>();

        Employee employee = new Employee(); // Create an employee object
        Scanner sc = new Scanner(System.in);

        // Loop to show the menu and take user input
        while (true) {
            System.out.println("=== Welcome to the Employee Payroll Management System ===\n");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Calculate Annual Salary");
            System.out.println("4. Give Salary Raise");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt(); // Get user's choice
            sc.nextLine(); // Clear the buffer

            // Add new employee
            if (choice == 1) {
                System.out.print("Enter Employee's Name: ");
                String employeeName = sc.nextLine(); // Get employee name
                employeesName.add(employeeName); // Add to list
                System.out.print("Enter Employee's ID: ");
                int employeeID = sc.nextInt(); // Get employee ID
                employeesID.add(employeeID); // Add to list
                System.out.print("Enter Employee's Salary: ");
                double employeeSalary = sc.nextDouble(); // Get employee salary
                employeesSalary.add(employeeSalary); // Add to list
                sc.nextLine(); // Clear the buffer
                System.out.print("Enter Employee's Department: ");
                String employeeDepartment = sc.nextLine(); // Get department
                employeesDepartment.add(employeeDepartment); // Add to list

                System.out.println("*** Successfully Added ***");

                // Create the employee object with the new details
                employee = new Employee(employeeName, employeeID, employeeSalary, employeeDepartment);
            }
            // View all employees
            else if (choice == 2) {
                employee.displayInfo(employeesName, employeesID, employeesSalary, employeesDepartment);
            }
            // Calculate annual salary
            else if (choice == 3) {
                employee.CalculateAnnualSalary(employeesID, employeesSalary, employeesName);
            }
            // Raise salary
            else if (choice == 4) {
                double percentage = 0; // Initialize percentage
                employee.raiseSalary(percentage, employeesSalary, employeesID, employeesName);
            }
            // Exit the program
            else {
                System.out.println("Exiting......");
                break; // Exit the loop
            }
        }
        sc.close(); // Close the scanner
    }
}