package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = Integer.parseInt(sc.nextLine());
        int y1 = Integer.parseInt(sc.nextLine());
        int x2 = Integer.parseInt(sc.nextLine());
        int y2 = Integer.parseInt(sc.nextLine());
        int x3 = Integer.parseInt(sc.nextLine());
        int y3 = Integer.parseInt(sc.nextLine());
        int x4 = Integer.parseInt(sc.nextLine());
        int y4 = Integer.parseInt(sc.nextLine());

        printOfTheClosest(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    static void printOfTheClosest(int x1, int y1, int x2, int y2,int x3,int y3,int x4, int y4) {

        if (DistanceBetweenTwoPoints(x1, y1, x2, y2) >= DistanceBetweenTwoPoints(x3, y3, x4, y4)) {
            ClosestPoint(x1, y1, x2, y2);
        } else {
            ClosestPoint(x3, y3, x4, y4);
        }
    }
    static void ClosestPoint(int x1, int y1, int x2, int y2) {
        if (DistanceBetweenTwoPoints(x1, y1, 0, 0) <= DistanceBetweenTwoPoints(x2, y2, 0, 0)) {
            System.out.printf("(%d, %d)", x1,y1);
            System.out.printf("(%d, %d)", x2,y2);
        } else {
            System.out.printf("(%d, %d)", x2,y2);
            System.out.printf("(%d, %d)", x1,y1);
        }
    }

    static double DistanceBetweenTwoPoints(int x1, int y1, int x2, int y2)
    {
        double xDiff = x2 - x1;
        double yDiff = y2 - y1;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
