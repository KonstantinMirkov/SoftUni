package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Refactoring_PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 2; i <= n; i++) {
            boolean check = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i , check);
        }
    }
}
