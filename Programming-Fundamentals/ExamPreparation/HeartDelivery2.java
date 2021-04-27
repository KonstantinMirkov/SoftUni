package com.JavaFundamentals.ExamPreparation;

import java.util.*;

public class HeartDelivery2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] houses = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int currentIndex = 0;
        while (!input.equals("Love!")) {
            String[] commands = input.split("\\s+");
            int jumpLength = Integer.parseInt(commands[1]);
            currentIndex += jumpLength;
            if (currentIndex >= houses.length) {
                currentIndex = 0;
            }
            if (houses[currentIndex] != 0) {
                houses[currentIndex] -= 2;
                if (houses[currentIndex] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        boolean successfulMission = true;
        for (int house : houses) {
            if (house != 0) {
                successfulMission = false;
                break;
            }
        }
        int housesCount = 0;
        for (int house : houses) {
            if (house != 0) {
                housesCount++;
            }
        }
        if (successfulMission) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", housesCount);
        }
    }
}
