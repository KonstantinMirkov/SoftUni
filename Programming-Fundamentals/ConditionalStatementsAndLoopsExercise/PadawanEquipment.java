package com.JavaFundamentals.ConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Equipment: lightSabers, belts and robes
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        //sabresPrice*(studentsCount + 10%) + robesPrice * (studentsCount) + beltsPrice*(studentsCount-freeBelts)
        double totalPriceSabers = priceLightSabers * Math.ceil(students * 1.1);
        double totalPriceRobes = students * priceRobes;
        double totalPriceBelts = (students - students / 6) * priceBelts;

        double totalPrice = totalPriceBelts + totalPriceRobes + totalPriceSabers;
        if(totalPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.",  totalPrice - money);
        }

    }
}
