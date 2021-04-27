package com.JavaFundamentals.ExamPreparation;

import java.util.*;

public class MuOnline2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] separator = scanner.nextLine().split("\\|+");
        int initialHealth = 100;
        int initialBitcoins = 0;
        int bestRoom = 0;

        boolean alive = true;

        for (int i = 0; i < separator.length; i++) {
            String[] commands = separator[i].split("\\s+");
            String command = commands[0];
            bestRoom++;

            if (command.equalsIgnoreCase("potion")) {
                int healthIncrease = Integer.parseInt(commands[1]);
                int currentHealth = initialHealth;
                initialHealth += healthIncrease;
                if (initialHealth > 100) {
                    initialHealth = 100;
                    int amountHealed = 100 - currentHealth;
                    System.out.printf("You healed for %d hp.%n", amountHealed);
                } else {
                    System.out.printf("You healed for %d hp.%n", healthIncrease);
                }
                System.out.printf("Current health: %d hp.%n", initialHealth);
            } else if (command.equalsIgnoreCase("chest")) {
                int bitcoinsFound = Integer.parseInt(commands[1]);
                initialBitcoins += bitcoinsFound;
                System.out.printf("You found %d bitcoins.%n", bitcoinsFound);
            } else {
                int damage = Integer.parseInt(commands[1]);
                initialHealth -= damage;
                if (initialHealth <= 0) {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", bestRoom);
                    alive = false;
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", command);
                }
            }
        }
        if (alive) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", initialBitcoins);
            System.out.printf("Health: %d%n", initialHealth);
        }

    }
}
