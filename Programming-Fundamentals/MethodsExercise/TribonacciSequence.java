package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class TribonacciSequence {
    static void printTrib(int n) {
        if (n < 1) {
            return;
        }
        int first = 1, second = 1;
        int third = 2;

        System.out.print(first + " ");
        if (n > 1) {
            System.out.print(second + " ");
        }
        if (n > 2) {
            System.out.print(third + " ");
        }

        for (int i = 3; i < n; i++) {
            int curr = first + second + third;
            first = second;
            second = third;
            third = curr;

            System.out.print(curr +" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printTrib(n);
    }
}
