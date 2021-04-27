package com.JavaFundamentals.ArraysExercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int rotations = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rotations; i++) {
            String firstNum = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstNum;
        }
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }
    }
}
