package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    static int GetTheSumOfEvenDigits(int number) {
        int evenSum = 0;

        while (number > 0)
        {
            int lastDigit = number % 10;
            number = number / 10;

            if (lastDigit % 2 == 0)
            {
                evenSum += lastDigit;
            }
        }

        return evenSum;
    }

    static int GetTheSumOfOddDigits(int number) {
        int oddSum = 0;

        while (number > 0)
        {
            int lastDigit = number % 10;
            number = number / 10;

            if (lastDigit % 2 != 0)
            {
                oddSum += lastDigit;
            }
        }

        return oddSum;
    }

    static int MultipliesEvensToOdds(int n) {
        int evenSum = GetTheSumOfEvenDigits(n);
        int oddSum = GetTheSumOfOddDigits(n);

        return evenSum * oddSum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(Integer.parseInt(sc.nextLine()));

        int result = MultipliesEvensToOdds(n);
        System.out.println(result);
    }
}
