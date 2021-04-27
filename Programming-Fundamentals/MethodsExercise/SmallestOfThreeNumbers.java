package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int y = sc.nextInt();

        int z = sc.nextInt();
        System.out.print(smallest(x, y, z));
    }

    public static int smallest(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
