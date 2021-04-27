package com.JavaFundamentals.ListsExercise;

import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] split = input.split("\\s+");

        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < split.length / 2; i++) {


            if (Integer.parseInt(split[i]) != 0) {
                sum1 += Integer.parseInt(split[i]);
            } else {
                sum1 *= 0.8;
            }
        }

        for (int i = split.length - 1; i > split.length / 2; i--) {

            if (Integer.parseInt(split[i]) != 0) {
                sum2 += Integer.parseInt(split[i]);
            } else {
                sum2 *= 0.8;
            }
        }

        if (sum1 < sum2) {
            System.out.printf("The winner is left with total time: %.1f", sum1);
        }else {
            System.out.printf("The winner is right with total time: %.1f", sum2);
        }
    }
}
