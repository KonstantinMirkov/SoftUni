package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n1 = Integer.parseInt(sc.nextLine());
        long n2 = Integer.parseInt(sc.nextLine());

        double result = calculateFactorial(n1) * 1.0 / calculateFactorial(n2);
        System.out.printf("%.2f", result);
    }

    static long calculateFactorial(long n){
        long factorial = 1;
        for (long i = 1; i <= n ; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
