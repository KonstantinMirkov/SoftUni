package com.JavaFundamentals.ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        int targetSumNumber = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == targetSumNumber) {

                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }
    }
}
