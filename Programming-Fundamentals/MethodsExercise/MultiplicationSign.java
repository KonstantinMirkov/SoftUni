package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = Integer.parseInt(sc.nextLine());
        int num2 = Integer.parseInt(sc.nextLine());
        int num3 = Integer.parseInt(sc.nextLine());

        productType(num1, num2, num3);
    }

    static void productType(int num1, int num2, int num3) {
        int product = num1 * num2 * num3;
        if (product == 0) {
            System.out.println("zero");
        } else if (product < 0) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
}
