package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            String input = sc.nextLine();
            int ascii = input.charAt(0);
            sum += ascii;

        }
        System.out.printf("The sum equals: %d", sum);
    }
}
