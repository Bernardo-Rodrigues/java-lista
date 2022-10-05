package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private final List<Employee> employees;

    public Company(){
        this.employees = new ArrayList<>();
    }

    public boolean addEmployee(Integer id, String name, Double salary){
        Employee existentEmployee = this.employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);

        if(!(existentEmployee == null)){
            System.out.println("Already exists an employee with this id!");
            return false;
        }

        Employee employee = new Employee(id, name, salary);

        this.employees.add(employee);
        return true;
    }

    public void listEmployees(){
        System.out.println("List of employees:");
        for (Employee employee: employees){
            System.out.println(employee.getId() + ", " + employee.getName() + ", " + employee.getSalary());
        }
    }

    public boolean increaseEmployeeSalary(Integer employeeId, Scanner scan){
        Employee employee = this.employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst().orElse(null);

        if(employee == null) {
            System.out.println("Invalid employee id!");
            return false;
        }

        System.out.print("Enter the percentage: ");
        Double percentage = scan.nextDouble();
        Double newSalary = employee.getSalary() + (employee.getSalary() * percentage / 100);
        employee.setSalary(newSalary);

        return true;
    }
}
