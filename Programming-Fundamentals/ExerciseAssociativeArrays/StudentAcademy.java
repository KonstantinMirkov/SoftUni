package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String,List<Double>> studentData = new LinkedHashMap<>();

        NumberOfStudents(scanner, numberOfStudents, studentData);
        AverageOfAGrade(studentData);
    }

    private static void NumberOfStudents(Scanner scanner, int numberOfStudents, Map<String, List<Double>> studentData) {
        for (int i = 0; i < numberOfStudents; i++) {
            String nameOfAStudent = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            IfStudentNameExistsOrNot(studentData, nameOfAStudent, grade);
        }
    }

    private static void IfStudentNameExistsOrNot(Map<String, List<Double>> studentData, String nameOfAStudent, double grade) {
        if (!studentData.containsKey(nameOfAStudent)) {
            studentData.put(nameOfAStudent, new ArrayList<>());
        }
        studentData.get(nameOfAStudent).add(grade);
    }

    private static void AverageOfAGrade(Map<String, List<Double>> studentData) {
        Map<String, Double> averageGrades = new LinkedHashMap<>();
        for (Map.Entry<String,List<Double>> entry : studentData.entrySet()) {
            double averageGrade= entry.getValue().stream().mapToDouble(x -> x).average().getAsDouble();

            if(averageGrade >= 4.50){
                averageGrades.put(entry.getKey(), averageGrade);
            }
        }
        Print(averageGrades);
    }

    private static void Print(Map<String, Double> averageGrades) {
        averageGrades.entrySet().stream()
                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.println(String.format("%s -> %.2f", grade.getKey(), grade.getValue()));
                });
    }
}
