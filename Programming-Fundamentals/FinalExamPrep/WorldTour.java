package com.JavaFundamentals.FinalExamPrep;

import java.util.*;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder initialDestination = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commandParts = input.split(":");
            String command = commandParts[0];
            switch (command) {
                case "Add Stop":
                    int addStopIndex = Integer.parseInt(commandParts[1]);
                    String stopToAdd = commandParts[2];

                    if (addStopIndex >= 0 && addStopIndex < initialDestination.length()) {
                        initialDestination.insert(addStopIndex, stopToAdd);
                    }
                    System.out.println(initialDestination);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    if (startIndex >= 0 && startIndex < initialDestination.length()
                            && endIndex >= 0 && endIndex < initialDestination.length()) {
                        initialDestination.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(initialDestination);
                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    if (initialDestination.indexOf(oldString) != -1) {
                        int switchStartIndex = initialDestination.indexOf(oldString);
                        int switchEndIndex = switchStartIndex + oldString.length();
                        initialDestination.replace(switchStartIndex, switchEndIndex, newString);
                    }
                    System.out.println(initialDestination);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + initialDestination);
    }
}