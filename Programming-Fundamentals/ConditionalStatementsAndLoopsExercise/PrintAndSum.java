package com.JavaFundamentals.ConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = n; i <= m; i++) {
            System.out.printf(i + " ");
            sum += i;

        }System.out.println();
        System.out.printf("Sum: %d%n", sum);

    }
}
