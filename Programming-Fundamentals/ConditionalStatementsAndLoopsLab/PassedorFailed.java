package com.JavaFundamentals.ConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class PassedorFailed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grade = Double.parseDouble(sc.nextLine());
        if (grade >= 3.00 ){
            System.out.println("Passed!");
        }else if (grade <= 2.99 ){
            System.out.println("Failed!");
        }
        else{
            System.out.println();
        }
    }
}
