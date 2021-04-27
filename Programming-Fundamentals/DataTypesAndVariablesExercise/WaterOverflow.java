package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int totalLiters = 0;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(sc.nextLine());
            if (liters + totalLiters > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                totalLiters += liters;
            }
        }
        System.out.println(totalLiters);
    }
}
