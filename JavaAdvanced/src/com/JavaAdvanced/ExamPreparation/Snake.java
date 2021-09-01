package com.JavaAdvanced.ExamPreparation;

import java.util.*;

public class Snake {

    static int countOfFood = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] territory = readMatrix(scanner, Integer.parseInt(scanner.nextLine()));

        int[] playerPosition = findIndexes(territory, 'S');

        while (countOfFood < 10) {
            String input = scanner.nextLine();
            territory[playerPosition[0]][playerPosition[1]] = '.';
            switch (input) {
                case "up":
                    playerPosition[0]--;
                    break;
                case "down":
                    playerPosition[0]++;
                    break;
                case "left":
                    playerPosition[1]--;
                    break;
                case "right":
                    playerPosition[1]++;
                    break;
            }
            if (indexIsInTerritory(playerPosition, territory)) {
                if (territory[playerPosition[0]][playerPosition[1]] == '*') {
                    countOfFood++;
                    territory[playerPosition[0]][playerPosition[1]] = 'S';
                } else if (territory[playerPosition[0]][playerPosition[1]] == 'B') {
                    territory[playerPosition[0]][playerPosition[1]] = '.';
                    playerPosition = findIndexes(territory, 'B');
                }
            } else {
                break;
            }
        }
        if (countOfFood < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + countOfFood);

        printMatrix(territory);

    }

    private static boolean indexIsInTerritory(int[] currentPosition, char[][] territory) {
        return currentPosition[0] >= 0 && currentPosition[0] < territory.length
                && currentPosition[1] >= 0 && currentPosition[1] < territory.length;
    }

    private static int[] findIndexes(char[][] matrix, char toFind) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == toFind) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }

    private static char[][] readMatrix(Scanner scan, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] territory) {
        Arrays.stream(territory).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }
}
