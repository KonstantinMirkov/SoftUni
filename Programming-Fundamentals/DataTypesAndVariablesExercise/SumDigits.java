package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int currentNum = (int) input.charAt(i) - 48;
            sum += currentNum;
        }
        System.out.println(sum);
    }
}
