package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {

            double n1 = Double.parseDouble(sc.next());
            double n2 = Double.parseDouble(sc.next());

            int sum = 0;
            if (n1 > n2) {
                double numFirst = Math.abs(n1);
                while (numFirst > 0) {
                    sum += (numFirst % 10);
                    numFirst /= 10;
                }
            } else {
                double numSecond = Math.abs(n2);
                while (numSecond > 0) {
                    sum += (numSecond % 10);
                    numSecond /= 10;

                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
