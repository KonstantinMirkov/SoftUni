package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> studentsData = new TreeMap<>();
        sumGraduates(scanner, studentsCount, studentsData);
        printGraduates(studentsData);
    }

    private static void sumGraduates(Scanner scanner, int studentsCount, Map<String, Double[]> studentsData) {
        for (int i = 0; i < studentsCount; i++) {
            String studentName = scanner.nextLine();
            String[] studentsScores = scanner.nextLine().split("\\s+");
            Double[] studentGrades = new Double[studentsScores.length];

            for (int j = 0; j < studentsScores.length; j++) {
                studentGrades[j] = Double.parseDouble(studentsScores[j]);
            }
                studentsData.put(studentName, studentGrades);

        }
    }

    private static void printGraduates(Map<String, Double[]> studentsData) {
        studentsData.forEach((student, grade) -> {
            double gradesSum = 0;
            for (Double g : grade) {
                gradesSum += g;
            }
            double averageSum = gradesSum / grade.length;
            System.out.println(student + " is graduated with " + averageSum);
        });
    }
}
