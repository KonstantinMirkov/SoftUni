package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = Integer.parseInt(sc.nextLine());
        int y1 = Integer.parseInt(sc.nextLine());
        int x2 = Integer.parseInt(sc.nextLine());
        int y2 = Integer.parseInt(sc.nextLine());

        printOfTheClosest(x1, y1, x2, y2);
    }

    static void printOfTheClosest(int x1, int y1, int x2, int y2) {
        double c1 = Math.abs(Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2)));
        double c2 = Math.abs(Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2)));
        if (c2 < c1) {
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x1, y1);
        }

    }
}
