package application;

import entities.Company;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Company company = new Company();

    public static void main(String[] args) {
        readEmployees();
        increaseSalaryOfOneEmployee();
        System.out.println();
        company.listEmployees();
    }

    public static void readEmployees(){
        System.out.print("How many employees will be registered? ");
        int employeesQuantity = scan.nextInt();

        for (int i = 0; i < employeesQuantity; i++){
            boolean result;
            do{
                System.out.println("Employee #" + (i + 1) + ":");
                System.out.print("Id: ");
                Integer id = scan.nextInt();
                System.out.print("Name: ");
                scan.nextLine();
                String name = scan.nextLine();
                System.out.print("Salary: ");
                Double salary = scan.nextDouble();

                result = company.addEmployee(id, name, salary);
            }while (!result);
        }
    }

    public static void increaseSalaryOfOneEmployee(){
        System.out.println();
        boolean result;
        do{
            System.out.print("Enter the employee id that is going to have salary increased: ");
            Integer employeeId = scan.nextInt();
            result = company.increaseEmployeeSalary(employeeId, scan);
        }while (!result);
    }
}
