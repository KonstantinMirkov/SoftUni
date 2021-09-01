package com.JavaAdvanced.DefiningClasses.CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeesCount = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();

        while (employeesCount-- > 0){
            String[] input = scanner.nextLine().split("\\s+");

            Employee employee = new Employee(input[0],Double.parseDouble(input[1]),input[2],input[3]);

            employee.setName(input[0]);
            employee.setSalary(Double.parseDouble(input[1]));
            employee.setPosition(input[2]);
            employee.setDepartment(input[3]);

            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                        employee.setAge(Integer.parseInt(input[5]));
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                        employee.setEmail(input[5]);
                    }
                    break;
            }

            employees.add(employee);
        }
        List<String> departmentsList = employees.stream().map(Employee::getDepartment).collect(Collectors.toList());

        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department,
                    employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }

    }
}
