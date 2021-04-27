package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        ;
        Scanner sc = new Scanner(System.in);
        String drinkOrFood = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        double price = 0;
        double totalPrice = 0;

        switch (drinkOrFood) {
            case "coffee":
                price = 1.50;
                totalPrice = price * n;
                break;
            case "water":
                price = 1.0;
                totalPrice = price * n;
                break;
            case "coke":
                price = 1.40;
                totalPrice = price * n;
                break;
            case "snacks":
                price = 2.00;
                totalPrice = price * n;
                break;
        }
        System.out.printf("%.2f",totalPrice);
    }
}
