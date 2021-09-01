package com.JavaAdvanced.JavaAdvancedExam;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        //матрица от символи:
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        //index 0 - the row of the player.
        //index 1 - the column.
        int[] position = new int[2];

        for (int row = 0; row < sizeOfMatrix; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("P")) {
                position[0] = row; // Реда на който се намира играча.
                position[1] = line.indexOf("P"); // Колоната е там, където се намира играча.
            }
        }


        boolean playerWon = false;
        while (commandsCount-- > 0 && !playerWon) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                playerWon = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                playerWon = movePlayer(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                playerWon = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                playerWon = movePlayer(position, matrix, 0, +1);
            }
        }

        if (playerWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static boolean movePlayer(int[] position, char[][] matrix, int rowModification, int colModification) {
        //UP: row - 1
        //DOWN:  row + 1
        //LEFT: col - 1
        //RIGHT: col + 1
        int row = position[0];
        int col = position[1];
        int newRow = indexIsInBounds(row + rowModification, matrix.length);
        int newCol = indexIsInBounds(col + colModification, matrix.length);

        boolean hasWon = false;

        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        } else if (matrix[newRow][newCol] == 'B') {
            newRow = indexIsInBounds(newRow + rowModification, matrix.length);
            newCol = indexIsInBounds(newCol + colModification, matrix.length);
            if (matrix[newRow][newCol] == 'F') {
                hasWon = true;
            }
        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        }

        matrix[row][col] = '.';
        matrix[newRow][newCol] = 'P';
        position[0] = newRow;
        position[1] = newCol;
        return hasWon;
    }

    private static int indexIsInBounds(int index, int matrixBounds) {
        if (index < 0) {
            index = matrixBounds - 1;
        } else if (index >= matrixBounds) {
            index = 0;
        }
        return index;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] array : matrix) {
            for (char symbol : array) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
