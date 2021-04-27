package com.JavaFundamentals.CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee() {
        this.email = "n/a";
        this.age = -1;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void setPosition(String position) {
        this.position = position;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setAge(int age) {
        this.age = age;
    }

    double getSalary() {
        return salary;
    }

    String getDepartment() {
        return department;
    }

    String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    String getEmail() {
        return email;
    }

    int getAge() {
        return age;
    }
}
