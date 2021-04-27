package NestedLoopsExercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        double totalScore = 0.0;
        int countPresentations = 0;
        while (!line.equals("Finish")) {
            String presentation = line;
            countPresentations++;

            double gradeSum = 0.0;
            double averageGrade = 0.0;
            for (int i = 0; i < n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradeSum += grade;
            }
            averageGrade = gradeSum / n;
            totalScore += averageGrade;
            System.out.printf("%s - %.2f.%n", presentation, averageGrade);

            line = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalScore / countPresentations);
    }
}
