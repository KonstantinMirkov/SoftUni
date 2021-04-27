package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void maxNums(int maxNum ) {

        for (int i = 1; i <=maxNum ; i++) {
            System.out.print(i);
            if (i < maxNum){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for (int i = 1; i <= n ; i++) {
            maxNums(i);
        }
        for (int i = n - 1; i >= 1 ; i--) {
            maxNums(i);
        }
    }
}
