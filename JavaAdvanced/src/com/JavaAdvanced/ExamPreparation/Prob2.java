package com.JavaAdvanced.ExamPreparation;

import java.util.*;

public class Prob2 {
    static int pythonLength = 1;
    static int foodCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        int[] playerPosition = new int[2];

        for (int row = 0; row < sizeOfMatrix; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if (matrix[row][col] == 's') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }

                if (matrix[row][col] == 'f') {
                    foodCount++;
                }
            }
        }


        boolean gameIsUnfinished = true;

        for (int i = 0; i < commands.length; i++) {

            String command = commands[i];

            while (gameIsUnfinished && foodCount > 0) {

                if (command.equals("up")) {

                    gameIsUnfinished = movePython(playerPosition, matrix, -1, 0);
                    break;
                } else if (command.equals("down")) {
                    gameIsUnfinished = movePython(playerPosition, matrix, +1, 0);
                    break;
                } else if (command.equals("left")) {
                    gameIsUnfinished = movePython(playerPosition, matrix, 0, -1);
                    break;
                } else if (command.equals("right")) {
                    gameIsUnfinished = movePython(playerPosition, matrix, 0, +1);
                    break;
                }

            }
            if (foodCount == 0) {
                System.out.printf("You win! Final python length is %d%n", pythonLength);
                break;
            }
        }

        if (foodCount > 0 && gameIsUnfinished) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
        }

    }

    public static void print(char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean movePython(int[] playerPosition, char[][] matrix, int rowModifier, int colModifier) {

        int row = playerPosition[0];
        int col = playerPosition[1];

        matrix[row][col] = '*';

        int newRol = indexIsInBounds(row + rowModifier, matrix.length);
        int newCol = indexIsInBounds(col + colModifier, matrix.length);

        char currentSymbol = matrix[newRol][newCol];

        if (currentSymbol == 'f') {
            matrix[newRol][newCol] = '*';
            pythonLength++;
            foodCount--;
        } else if (currentSymbol == 'e') {
            System.out.println("You lose! Killed by an enemy!");
            return false;
        }

        matrix[newRol][newCol] = 's';
        playerPosition[0] = newRol;
        playerPosition[1] = newCol;

        return true;

    }

    private static int indexIsInBounds(int index, int matrixLength) {
        if (index < 0) {
            index = matrixLength - 1;
        } else if (index >= matrixLength) {
            index = 0;
        }
        return index;
    }
}

