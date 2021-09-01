package com.JavaAdvanced.ExamPreparation;

import java.util.*;

public class Bee {

    static int pollinatedFlowersCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());


        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        int[] position = new int[2];

        for (int row = 0; row < sizeOfMatrix; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("B")) {
                position[0] = row; // Реда на който се намира пчелата.
                position[1] = line.indexOf("B"); // Колоната е там, където се намира пчелата.
            }
        }
        String command = scanner.nextLine();
        boolean beeIsInField = true;
        while (beeIsInField && !command.equals("End")) {
            if (command.equals("up")) {
                beeIsInField = moveBee(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                beeIsInField = moveBee(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                beeIsInField = moveBee(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                beeIsInField = moveBee(position, matrix, 0, +1);
            }
            command = scanner.nextLine();
        }

        if (!beeIsInField) {
            System.out.println("The bee got lost!");

            if (pollinatedFlowersCount >= 5) {
                System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowersCount);
            } else {
                System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowersCount);
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] array : matrix) {
            for (char symbol : array) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean moveBee(int[] position, char[][] matrix, int rowModification, int colModification) {
        int row = position[0];
        int col = position[1];
        int newRow = row + rowModification;
        int newCol = col + colModification;
        boolean isInBounds;

        isInBounds = isInBounds(matrix, newRow, newCol);
        if (isInBounds) {
            if (matrix[newRow][newCol] == 'f') {
                pollinatedFlowersCount++;
            } else if (matrix[newRow][newCol] == 'O') {
                newRow = newRow + rowModification;
                newCol = newCol + colModification;
                if (matrix[newRow][newCol] == 'f') {
                    pollinatedFlowersCount++;
                }
            }
            matrix[row][col] = '.';
            matrix[newRow][newCol] = 'B';
            position[0] = newRow;
            position[1] = newCol;
        }
        return isInBounds;
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
