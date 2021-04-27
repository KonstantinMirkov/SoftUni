package com.JavaFundamentals.ArraysExercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] first = new int[n];
        int[] second = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] line = sc.nextLine().split(" ");
            if (i % 2 == 0) {
                first[i - 1] = Integer.parseInt(line[1]);
                second[i - 1] = Integer.parseInt(line[0]);
            } else {
                first[i - 1] = Integer.parseInt(line[0]);
                second[i - 1] = Integer.parseInt(line[1]);
            }
        }
        for (int i = 0; i < first.length; i++) {
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < second.length; i++) {
            System.out.print(second[i] + " ");
        }
    }
}
