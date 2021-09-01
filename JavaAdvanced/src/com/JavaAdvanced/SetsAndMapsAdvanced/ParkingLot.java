package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> carNumbers = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String currentCar = input.split(", ")[1];
            if (input.contains("IN")) {
                carNumbers.add(currentCar);
            } else {
                carNumbers.remove(currentCar);
            }
            input = scanner.nextLine();
        }
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            carNumbers.forEach(System.out::println);
        }
    }
}
