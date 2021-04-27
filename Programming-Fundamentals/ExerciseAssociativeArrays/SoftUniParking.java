package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingUsers = new LinkedHashMap<>();

        Commands(scanner, numberOfCommands, parkingUsers);
        Print(parkingUsers);
    }

    private static void Print(Map<String, String> parkingUsers) {
        parkingUsers.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }

    private static void Commands(Scanner scanner, int numberOfCommands, Map<String, String> parkingUsers) {
        for (int i = 0; i < numberOfCommands; i++) {

            String[] commands = scanner.nextLine().split(" ");
            String command = commands[0];
            String username = commands[1];

            RegisteredAndUnregisteredCases(parkingUsers, commands, command, username);

        }
    }

    private static void RegisteredAndUnregisteredCases(Map<String, String> parkingUsers, String[] commands, String command, String username) {
        if (command.equals("register")) {
            String licensePlateNumber = commands[2];
            if (!parkingUsers.containsKey(username)) {
                parkingUsers.put(username, licensePlateNumber);
                System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
            } else {
                System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
            }
        } else if (command.equals("unregister")) {
            if (!parkingUsers.containsKey(username)) {
                System.out.printf("ERROR: user %s not found%n", username);
            } else {
                parkingUsers.remove(username);
                System.out.printf("%s unregistered successfully%n", username);
            }
        }
    }
}