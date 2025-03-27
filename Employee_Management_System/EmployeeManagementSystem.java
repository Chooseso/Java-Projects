// Base class representing a person
class Person {
    String name; // Name of the person
    int age;     // Age of the person

    // Constructor to initialize name and age
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to introduce the person
    void introduce() {
        System.out.println("Introducing Person: ");
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass representing an employee
class Employee extends Person {
    String jobTitle; // Job title of the employee

    // Constructor to initialize name, age, and job title
    Employee(String name, int age, String jobTitle) {
        super(name, age); // Call the superclass constructor
        this.jobTitle = jobTitle;
    }

    // Override the introduce method to include job title
    @Override
    void introduce() {
        System.out.println("Introducing Employee: ");
        System.out.println("Name: " + name + ", Age: " + age + ", Job Title: " + jobTitle);
    }
}

// Subclass representing a manager
class Manager extends Employee {
    String department; // Department of the manager

    // Constructor to initialize name, age, job title, and department
    Manager(String name, int age, String jobTitle, String department) {
        super(name, age, jobTitle); // Call the superclass constructor
        this.department = department;
    }

    // Override the introduce method to include department
    @Override
    void introduce() {
        System.out.println("Introducing Manager: ");
        System.out.println("Name: " + name + ", Age: " + age + ", Job Title: " + jobTitle + ", Department: " + department);
    }
}

// Bonus challenge: subclass representing an executive
class Executive extends Manager {
    String companyCar; // Company car of the executive

    // Constructor to initialize name, age, job title, department, and company car
    Executive(String name, int age, String jobTitle, String department, String companyCar) {
        super(name, age, jobTitle, department); // Call the superclass constructor
        this.companyCar = companyCar;
    }

    // Override the introduce method to include company car
    @Override
    void introduce() {
        System.out.println("Introducing Executive: ");
        System.out.println("Name: " + name + ", Age: " + age + ", Job Title: " + jobTitle + ", Department: " + department + ", Company Car: " + companyCar);
    }
}

// Employee Management System class to run the program
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create objects of each class
        Person person = new Person("Alice", 30);
        Employee employee = new Employee("Bob", 35, "Software Engineer");
        Manager manager = new Manager("Charlie", 40, "Project Manager", "IT");
        Executive executive = new Executive("Dave", 45, "Senior Executive", "Finance", "");

        // Call the introduce method on each object
        person.introduce();
        employee.introduce();
        manager.introduce();
        executive.introduce();
    }
}