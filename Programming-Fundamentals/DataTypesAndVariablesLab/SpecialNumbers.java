package com.JavaFundamentals.DataTypesAndVariablesLab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int num = 1; num <= n; num++) {
            int digitsSum = 0;
            int digits = num;
            while (digits > 0) {
                digitsSum += digits % 10;
                digits /= 10;
            }
            if (digitsSum == 5 || digitsSum == 7 || digitsSum == 11){
                System.out.printf("%d -> True%n",num);
            }else {
                System.out.printf("%d -> False%n",num);
            }


        }
    }
}
