package com.JavaAdvanced.MultidimensionalArrays;

import com.sun.tools.javac.Main;

import java.util.*;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());

        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        int rowOfPlayer = 7;
        int colOfPlayer = 7;
        String lastSpell = "";

        boolean isPlagueCloudActive = false;
        while (true) {

            String[] commands = scanner.nextLine().split("\\s+");
            String spell = commands[0];
            int row = Integer.parseInt(commands[1]);
            int col = Integer.parseInt(commands[2]);

            heiganHitPoints -= damage;

            if (isPlagueCloudActive) {
                playerHitPoints -= 3500;
                isPlagueCloudActive = false;
            }

            if (heiganHitPoints <= 0 || playerHitPoints <= 0) {
                break;
            }

            boolean[][] field = castSpell(row, col);

            if (field[rowOfPlayer][colOfPlayer]) {
                if (isInBounds(rowOfPlayer - 1, colOfPlayer)
                        && !field[rowOfPlayer - 1][colOfPlayer]) {
                    rowOfPlayer--;
                } else if (isInBounds(rowOfPlayer, colOfPlayer + 1)
                        && !field[rowOfPlayer][colOfPlayer + 1]) {
                    colOfPlayer++;
                } else if (isInBounds(rowOfPlayer + 1, colOfPlayer)
                        && !field[rowOfPlayer + 1][colOfPlayer]) {
                    rowOfPlayer++;
                } else if (isInBounds(rowOfPlayer, colOfPlayer - 1)
                        && !field[rowOfPlayer][colOfPlayer - 1]) {
                    colOfPlayer--;
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHitPoints -= 3500;
                            isPlagueCloudActive = true;
                            spell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHitPoints -= 6000;

                            break;
                    }
                    lastSpell = spell;
                }

            }
        }
        playerOutputData(playerHitPoints, heiganHitPoints, lastSpell);

        playerFinalPosition(rowOfPlayer, colOfPlayer);

    }

    private static void playerFinalPosition(int rowOfPlayer, int colOfPlayer) {
        System.out.println("Final position: " + rowOfPlayer + ", " + colOfPlayer);
    }

    private static void playerOutputData(int playerHitPoints, double heiganHitPoints, String lastSpell) {
        if (heiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        }

        if (playerHitPoints <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerHitPoints);
        }
    }

    private static boolean[][] castSpell(int row, int col) {
        boolean[][] field = new boolean[15][15];
        for (int c = col - 1; c <= col + 1; c++) {

            topRow(row, field, c);

            currentRow(row, field, c);

            bottomRow(row, field, c);
        }
        return field;
    }

    private static void bottomRow(int row, boolean[][] field, int c) {
        if (isInBounds(row + 1, c)) {
            field[row + 1][c] = true;
        }
    }

    private static void currentRow(int row, boolean[][] field, int c) {
        if (isInBounds(row, c)) {
            field[row][c] = true;
        }
    }

    private static void topRow(int row, boolean[][] field, int c) {
        if (isInBounds(row - 1, c)) {
            field[row - 1][c] = true;
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }
}
