package com.JavaFundamentals.ExamPreparation;

import java.util.*;

public class BonusScopingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = Integer.parseInt(sc.nextLine());
        int lectures = Integer.parseInt(sc.nextLine());
        int bonus = Integer.parseInt(sc.nextLine());
        double maxBonus = Integer.MIN_VALUE;
        int maxAttended = Integer.MIN_VALUE;
        if (lectures == 0) {
            System.out.println("Max Bonus: 0.%n");
            System.out.println("The student has attended 0 lectures.");
        } else {
            for (int i = 0; i < students; i++) {
                int studentAttendances = Integer.parseInt(sc.nextLine());

                double totalBonus = (studentAttendances * 1.0 / lectures) * (5 + bonus);

                if (totalBonus > maxBonus) {
                    maxBonus = totalBonus;
                    maxAttended = studentAttendances;
                }
            }
        }
        maxBonus = Math.ceil(maxBonus);
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttended);
    }
}

