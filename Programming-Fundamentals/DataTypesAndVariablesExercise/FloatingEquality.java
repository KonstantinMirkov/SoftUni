package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n1 = Double.parseDouble(sc.nextLine());
        double n2 = Double.parseDouble(sc.nextLine());
        double precisionEps = 0.000001;

        if (n1 < n2) {
            double temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if (n1 - n2 < precisionEps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
