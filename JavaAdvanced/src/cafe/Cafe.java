package cafe;

import java.util.*;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int maxAge = Integer.MIN_VALUE;
        for (Employee employee : this.employees) {
            if (employee.getAge() > maxAge) {
                maxAge = employee.getAge();
            }
        }
        for (Employee employee : this.employees) {
            if (employee.getAge() == maxAge) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployee(String name) {
        if (!this.employees.isEmpty()) {
            for (Employee employee : this.employees) {
                if (employee.getName().equals(name)) {
                    return employee;
                }
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }


    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employees working at Cafe ").append(name).append(":").append(System.lineSeparator());
        for (Employee employee : employees) {
            builder.append("Employee: ").append(employee.name).append(", ")
                    .append(employee.age).append(" from ").append(employee.country).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
