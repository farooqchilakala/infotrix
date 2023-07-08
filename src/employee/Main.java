package employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem("employee.json");
        // system.loadDataFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Save Data to File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter employee details:");
                    System.out.print("Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    Employee employee = new Employee(id, name, designation, salary);
                    system.addEmployee(employee);
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    System.out.println("Employee Details:");
                    system.displayEmployees();
                    break;
                case 3:
                    System.out.print("Enter the employee ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Employee searchedEmployee = system.searchEmployee(searchId);
                    if (searchedEmployee != null) {
                        System.out.println("Employee found:");
                        System.out.println(searchedEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Employee updateEmployee = system.searchEmployee(updateId);
                    if (updateEmployee != null) {
                        System.out.println("Enter updated employee details:");
                        System.out.print("Name: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("Designation: ");
                        String updatedDesignation = scanner.nextLine();
                        System.out.print("Salary: ");
                        double updatedSalary = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        updateEmployee.setName(updatedName);
                        updateEmployee.setDesignation(updatedDesignation);
                        updateEmployee.setSalary(updatedSalary);
                        system.updateEmployee(updateEmployee);
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    system.deleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully.");
                    break;
                case 6:
                    system.saveDataToFile();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
