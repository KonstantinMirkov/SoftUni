package com.JavaFundamentals.FinalExamPrep;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carData = new TreeMap<>();

        iteratingCarsBeginData(scanner, n, carData);

        String input = scanner.nextLine();
        iteratingBeforeStopCommand(scanner, carData, input);

        print(carData);
    }

    private static void print(Map<String, List<Integer>> carData) {
        carData.entrySet()
                .stream().sorted((left, right) -> right.getValue().get(0) - left.getValue().get(0))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }

    private static void iteratingBeforeStopCommand(Scanner scanner, Map<String, List<Integer>> carData, String input) {
        while (!input.equals("Stop")) {
            String[] commands = input.split(" : ");
            String command = commands[0];
            String carType = commands[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuel = Integer.parseInt(commands[3]);
                    List<Integer> carDrivingData = carData.get(carType);
                    int mileage = carDrivingData.get(0);
                    int fuelReal = carDrivingData.get(1);
                    if (fuelReal < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        mileage += distance;
                        fuelReal -= fuel;
                        carData.get(carType).set(0, mileage);
                        carData.get(carType).set(1, fuelReal);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carType, distance, fuel);
                    }
                    if (mileage > 100000) {
                        System.out.printf("Time to sell the %s!%n", carType);
                        carData.remove(carType);
                        break;
                    }
                    break;
                case "Refuel":
                    int fuelToFill = Integer.parseInt(commands[2]);
                    int currentFuel = carData.get(carType).get(1);
                    currentFuel += fuelToFill;
                    if (currentFuel >= 75) {
                        fuelToFill = (currentFuel - 75) - fuelToFill;
                        currentFuel = 75;
                    }
                    carData.get(carType).set(1, currentFuel);
                    System.out.printf("%s refueled with %d liters%n", carType, fuelToFill);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    int currentMileage = carData.get(carType).get(0);
                    int revertedDistance = currentMileage - kilometers;
                    if (revertedDistance < 10000) {
                        revertedDistance = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carType, kilometers);
                    }
                    carData.get(carType).set(0, revertedDistance);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void iteratingCarsBeginData(Scanner scanner, int n, Map<String, List<Integer>> carData) {
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            String carType = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);

            List<Integer> currentCarData = new LinkedList<>();
            currentCarData.add(mileage);
            currentCarData.add(fuel);
            carData.put(carType, currentCarData);
        }
    }
}
