package com.JavaFundamentals.ConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - 48;

            int fact= 1;
            for (int j = 1; j <= digit ; j++) {
                fact *= j;

            }
            sum += fact;
        }
        int nInput = Integer.parseInt(n);
        if (sum == nInput){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
