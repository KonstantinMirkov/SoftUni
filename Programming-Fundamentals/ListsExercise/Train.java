package com.JavaFundamentals.ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapability = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2) {
                int newWagon = Integer.parseInt(tokens[1]);
                wagons.add(newWagon);
            } else {
                int passengersToAdd = Integer.parseInt(tokens[0]);
                for (int index = 0; index <= wagons.size() - 1; index++) {
                    int passengersPerWagon = wagons.get(index);
                    if (passengersPerWagon + passengersToAdd <= maxCapability) {
                        wagons.set(index, passengersPerWagon + passengersToAdd);
                        break;
                    }
                }

            }
            input = sc.nextLine();
        }
        printList(wagons);


    }

    private static void printList(List<Integer> wagons) {
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
