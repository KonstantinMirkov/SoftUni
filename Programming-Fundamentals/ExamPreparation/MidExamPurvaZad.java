package com.JavaFundamentals.ExamPreparation;

import java.util.Scanner;

public class MidExamPurvaZad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double flourPrice = Double.parseDouble(sc.nextLine());
        double eggPrice = Double.parseDouble(sc.nextLine());
        double apronPrice = Double.parseDouble(sc.nextLine());

        double neededAprons = Math.ceil(students * 0.20 + students) * apronPrice;
        int freeFlour = students / 5;
        double neededFlour = students * flourPrice - (freeFlour * flourPrice);
        double neededEggs = 10 * students * eggPrice;

        double neededMoney = neededAprons + neededFlour + neededEggs;

        if (budget >= neededMoney) {
            System.out.printf("Items purchased for %.2f$.", neededMoney);
        } else {
            System.out.printf("%.2f$ more needed.", neededMoney - budget);
        }
    }
}
