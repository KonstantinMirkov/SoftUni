package com.JavaAdvanced.DefiningClasses.CarInfo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());
        while (carsCount-- > 0) {

            String[] carData = scanner.nextLine().split("\\s+");

            CarCar car = new CarCar();
            car.setBrand(carData[0]);
            car.setModel(carData[1]);
            car.setHorsePower(Integer.parseInt(carData[2]));

            System.out.println(car.toString());
        }
    }
}
