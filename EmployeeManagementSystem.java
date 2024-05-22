//employee management system

import java.util.*;

// Abstract superclass Employee
abstract class Employee {
    protected String name;
    protected String employeeID;

     Employee(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

     abstract double calculateSalary();

     abstract String evaluatePerformance();

    @Override
     public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + name;
    }
}

// Subclass FullTimeEmployee
class FullTimeEmployee extends Employee {
     double monthlySalary;
     double performanceBonus;

     FullTimeEmployee(String name, String employeeID, double monthlySalary, double performanceBonus) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
        this.performanceBonus = performanceBonus;
    }

    @Override
     double calculateSalary() {
        return monthlySalary + performanceBonus;
    }

    @Override
     String evaluatePerformance() {
        // Implement your own performance evaluation logic
        return "Performance evaluated for full-time employee.";
    }

    @Override
     public String toString() {
        return super.toString() + ", Monthly Salary: " + monthlySalary + ", Performance Bonus: " + performanceBonus;
    }
}

// Subclass PartTimeEmployee
class PartTimeEmployee extends Employee {
     double hourlyRate;
     int hoursWorked;

     PartTimeEmployee(String name, String employeeID, double hourlyRate, int hoursWorked) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
     double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
     String evaluatePerformance() {
        return "Performance evaluation not applicable for part-time employee.";
    }

    @Override
     public String toString() {
        return super.toString() + ", Hourly Rate: " + hourlyRate + ", Hours Worked: " + hoursWorked;
    }
}

// Main class EmployeeManagementSystem
 public class EmployeeManagementSystem {
     static List<Employee> employees = new ArrayList<>();
     static Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management System:");
            System.out.println("1. Register Employee");
            System.out.println("2. Calculate Salary");
            System.out.println("3. Evaluate Performance");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    calculateSalary();
                    break;
                case 3:
                    evaluatePerformance();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

     static void registerEmployee() {
        System.out.print("Enter employee type (full-time/part-time): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        if (type.equals("full-time")) {
            System.out.print("Enter monthly salary: ");
            double monthlySalary = scanner.nextDouble();
            System.out.print("Enter performance bonus: ");
            double performanceBonus = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees.add(new FullTimeEmployee(name, employeeID, monthlySalary, performanceBonus));
            System.out.println("Full-time employee registered successfully.");
        } else if (type.equals("part-time")) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = scanner.nextDouble();
            System.out.print("Enter hours worked: ");
            int hoursWorked = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            employees.add(new PartTimeEmployee(name, employeeID, hourlyRate, hoursWorked));
            System.out.println("Part-time employee registered successfully.");
        } else {
            System.out.println("Invalid employee type.");
        }
    }

     static void calculateSalary() {
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.employeeID.equals(employeeID)) {
                System.out.println("Salary for " + employee.name + " (" + employee.employeeID + ") is: " + employee.calculateSalary());
                return;
            }
        }

        System.out.println("Employee not found.");
    }

     static void evaluatePerformance() {
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.employeeID.equals(employeeID)) {
                System.out.println("Performance for " + employee.name + " (" + employee.employeeID + "): " + employee.evaluatePerformance());
                return;
            }
        }

        System.out.println("Employee not found.");
    }

     static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees registered.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
