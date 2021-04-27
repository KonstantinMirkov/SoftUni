package com.JavaFundamentals.ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wagons = Integer.parseInt(sc.nextLine());

        int[] trains = new int[wagons];
        int people = 0;
        for (int i = 0; i < wagons; i++) {

            trains[i] = Integer.parseInt(sc.nextLine());
            people += trains[i];
        }
        for (int i = 0 ; i <trains.length ; i++) {
            System.out.print(trains[i] + " ");
        }
        System.out.println();
        System.out.printf("%d%n",people);
    }
}
