package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        String operator = sc.nextLine();
        int b = Integer.parseInt(sc.nextLine());
        operators(a, operator, b);
    }

    private static void operators(int a, String operator, int b) {
        int result = 0;
        switch (operator){
            case "+":
                result  = a + b;
                System.out.printf("%d",result);
                break;
            case "-":
                result  = a - b;
                System.out.printf("%d",result);
                break;
            case "/":
                result  = a / b;
                System.out.printf("%d",result);
                break;
            case "*":
                result  = a * b;
                System.out.printf("%d",result);
                break;
        }
    }
}
