package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String typeOfNum = sc.nextLine();

        if (typeOfNum.equals("int")) {
            int n = Integer.parseInt(sc.nextLine());
            n *= 2;
            System.out.println(n);
        } else if (typeOfNum.equals("real")) {
            double n3 = Double.parseDouble(sc.nextLine());
            n3 *= 1.5;
            System.out.printf("%.2f",n3);
        }

        if (typeOfNum.equals("string")) {
            String input = sc.nextLine();
            System.out.println("$" + input + "$");
        }
    }
}
