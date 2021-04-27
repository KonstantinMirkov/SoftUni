package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("END")) {
            palindromeNumber(input);
            input = sc.nextLine();
        }
    }

    private static void palindromeNumber(String number) {
        if (checkTheNumberForPalindrome(number)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    static boolean checkTheNumberForPalindrome(String number) {
        StringBuilder reversedNumber = new StringBuilder();
        reversedNumber.append(number);
        reversedNumber.reverse();
        String newReversedNumber = reversedNumber.toString();
        return newReversedNumber.equals(number);
    }
}
