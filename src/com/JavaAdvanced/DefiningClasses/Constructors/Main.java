package com.JavaAdvanced.DefiningClasses.Constructors;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());

        List<CarInfo> cars = new ArrayList<>();
        while (carsCount-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");

            CarInfo car;
            if (carData.length == 1) {
                car = new CarInfo(carData[0]);
            } else {
                car = new CarInfo(carData[0], carData[1], Integer.parseInt(carData[2]));
            }

                cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
