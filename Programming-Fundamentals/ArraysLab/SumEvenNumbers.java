package com.JavaFundamentals.ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt (Integer::parseInt)
                .toArray ();
        int sum = 0;

        for (int i = 0; i < numbers.length ; i++) {

            if (numbers[i] % 2 == 0){
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
