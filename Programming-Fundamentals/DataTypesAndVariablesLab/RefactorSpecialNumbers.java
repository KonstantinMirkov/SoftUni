package com.JavaFundamentals.DataTypesAndVariablesLab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= num; i++) {
            int sum = 0; int actualNum = i;
            while (i > 0) {
                sum += i % 10; i = i / 10;
            }
            boolean trueFalse = (sum == 5) || (sum == 7) || (sum == 11);
            String tF;
            if (trueFalse) {
                tF = "True";
            } else {
                tF = "False";
            }
            System.out.printf("%d -> %s%n", actualNum, tF);
            i = actualNum;
        }
    }
}
