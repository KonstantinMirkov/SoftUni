package com.JavaFundamentals.ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        for (int i = 0; i < numbers.length; i++) {
            boolean flag = true;
            int currentNum = numbers[i];
            for (int j = i+1; j < numbers.length; j++) {
                if (currentNum <= numbers[j]) {
                    flag = false;
                }
            }
            if (flag){
                System.out.print(currentNum + " ");
            }
        }
    }
}
