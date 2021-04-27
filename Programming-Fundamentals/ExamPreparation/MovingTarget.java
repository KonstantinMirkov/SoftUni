package com.JavaFundamentals.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];


            switch (command) {
                case "Shoot":
                    int shotIndex = Integer.parseInt(tokens[1]);
                    int power = Integer.parseInt(tokens[2]);
                    if (shotIndex >= 0 && shotIndex < targets.size()) {
                        targets.set(shotIndex, targets.get(shotIndex) - power);
                        if (targets.get(shotIndex) <= 0) {
                            targets.remove(shotIndex);
                        }
                    }
                    break;
                case "Add":
                    int indexToAdd = Integer.parseInt(tokens[1]);
                    if (indexToAdd >= 0 && indexToAdd < targets.size()) {
                        targets.add(indexToAdd, Integer.parseInt(tokens[2]));
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int index = Integer.parseInt(tokens[1]);
                    int radius = Integer.parseInt(tokens[2]);
                    if (index - radius >= 0 && index + radius < targets.size()) {
                        targets.subList(index - radius, index + radius + 1).clear();
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;

            }
            input = sc.nextLine();
        }
        System.out.print(targets.toString().replaceAll("[\\[\\]]", "").replaceAll(", ", "|"));
    }
}
