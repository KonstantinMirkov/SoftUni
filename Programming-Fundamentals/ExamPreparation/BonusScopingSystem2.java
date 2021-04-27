package com.JavaFundamentals.ExamPreparation;

import java.util.*;

public class BonusScopingSystem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = Integer.MIN_VALUE;
        int maxAttended = Integer.MIN_VALUE;

        if (lecturesCount == 0) {
            System.out.println("Max Bonus: 0.");
            System.out.println("The student has attended 0 lectures.");
        } else {
            for (int i = 0; i < studentsCount; i++) {
                int studentsAttendances = Integer.parseInt(scanner.nextLine());
                double totalBonus = (studentsAttendances * 1.0 / lecturesCount) * (5 + initialBonus);

                if (totalBonus > maxBonus) {
                    maxBonus = totalBonus;
                    maxAttended = studentsAttendances;
                }
            }

            maxBonus = Math.ceil(maxBonus);
            System.out.printf("Max Bonus: %.0f.%n", maxBonus);
            System.out.printf("The student has attended %d lectures.%n", maxAttended);
        }
    }
}
