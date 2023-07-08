package employee;



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private String dataFolderPath;

    public EmployeeManagementSystem(String dataFolderPath) {
        employees = new ArrayList<>();
        this.dataFolderPath = dataFolderPath;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("-------------------------");
        }
    }

    public Employee searchEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                break;
            }
        }
    }

    public void saveDataToFile() {
        for (Employee employee : employees) {
            String fileName = dataFolderPath + "/employee_" + employee.getId() + ".json";
            try (FileWriter writer = new FileWriter(fileName)) {
            } catch (IOException e) {
                System.out.println("Error occurred while saving data for employee " + employee.getId() + ": " + e.getMessage());
            }
        }
        System.out.println("Data saved successfully.");
    }
}
