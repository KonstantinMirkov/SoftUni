package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startingYield= Integer.parseInt(sc.nextLine());
        int days = 0;
        int totalAmount = 0;
        while (startingYield >= 100) {
            totalAmount += (startingYield - 26);
            days++;
            startingYield -= 10;
        }
        if (totalAmount > 26) {
            totalAmount -= 26;
        }

        System.out.println(days);
        System.out.println(totalAmount);
    }
}
