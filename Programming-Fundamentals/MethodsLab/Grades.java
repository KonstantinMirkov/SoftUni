package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class Grades {
    public static void positive() {
        Scanner scanner = new Scanner(System.in);
        double grades = Double.parseDouble(scanner.nextLine());

        if (grades >= 2.00 && grades <= 2.99) {
            System.out.println("Fail");
        }

        if (grades >= 3.00 && grades <= 3.49) {
            System.out.println("Poor");
        }

        if (grades >= 3.50 && grades <= 4.49) {
            System.out.println("Good");
        }

        if (grades >= 4.50 && grades <= 5.49) {
            System.out.println("Very good");
        }

        if (grades >= 5.50 && grades <= 6) {
            System.out.println("Excellent");
        }

    }

    public static void main(String[] args) {

        positive();

    }
}
