package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> studentData = new TreeMap<>();
        while (studentsCount-- > 0) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String studentName = studentInfo[0];
            double studentGrades = Double.parseDouble(studentInfo[1]);
                studentData.putIfAbsent(studentName, new ArrayList<>());
                studentData.get(studentName).add(studentGrades);

        }
        studentData.forEach((key, grades) -> {
            double gradesSum = 0;
            for (Double grade : grades) {
                gradesSum += grade;
            }
            double averageSum = gradesSum / grades.size();

            System.out.print(key + " -> ");
            grades.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", averageSum);
        });
    }
}
