package com.JavaFundamentals.ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        if(numbers.length < 1){
            System.out.print(0);
            return;
        }
        boolean flag = false;
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = i-1; j >= 0; j--) {
                leftSum += numbers[j];
            }
            for (int j = i+1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            if (leftSum == rightSum) {
                flag = true;
                System.out.print(i);
                break;
            }
        }
        if(!flag){
            System.out.print("no");
        }
    }
}
