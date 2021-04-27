package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double maxKeg = Double.MIN_VALUE;
        String biggerKegModel = "";
        for (int i = 0; i < n; i++) {
            String model = sc.nextLine();
            double radius = Double.parseDouble(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());

            double volume = Math.PI * radius * radius * height;
            if (volume > maxKeg) {
                maxKeg = volume;
                biggerKegModel = model;
            }
        }
        System.out.println(biggerKegModel);
    }
}
