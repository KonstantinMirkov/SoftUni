package com.JavaFundamentals.Students05;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String studentsData = sc.nextLine();

            String[] splittedData = studentsData.split("\\s+");
            String firstName = splittedData[0];
            String lastName = splittedData[1];
            double grade = Double.parseDouble(splittedData[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        List<Student> sortedList = students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());

        for (Student student : sortedList) {
            System.out.println(student);
        }
    }
}
