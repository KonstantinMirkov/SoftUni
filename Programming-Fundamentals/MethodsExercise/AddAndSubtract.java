package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());
        int n3 = Integer.parseInt(sc.nextLine());
        int result = sumOfTwoIntegers(n1,n2) - n3;
        System.out.println(result);
    }

    private static int sumOfTwoIntegers(int n1, int n2) {
        return n1 + n2;
    }
}
