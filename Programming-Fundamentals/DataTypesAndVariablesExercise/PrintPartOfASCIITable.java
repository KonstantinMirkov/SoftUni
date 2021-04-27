package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());

        for (int i = n; i <= n2; i++) {
            System.out.print((char)i + " " );
        }
    }
}
