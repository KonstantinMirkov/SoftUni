package com.JavaFundamentals.ConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int oddNumCount = Integer.parseInt(sc.nextLine());
        int sumOfOddNumbers = 0;
        int currentNum = 1;

        for (int i = oddNumCount; i > 0; i--)
        {
            sumOfOddNumbers += currentNum;
            System.out.println(currentNum);
            currentNum += 2;
        }
        System.out.println("Sum: " + sumOfOddNumbers);
    }
}
