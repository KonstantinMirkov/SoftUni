package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        fillRectangleMatrix(scanner, matrix, rows);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");

            if (!validateCommand(input, rows, cols)) {

                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;

            } else {
                int rowAtIndex1 = Integer.parseInt(commands[1]);
                int colAtIndex1 = Integer.parseInt(commands[2]);
                int rowAtIndex2 = Integer.parseInt(commands[3]);
                int colAtIndex2 = Integer.parseInt(commands[4]);

                String element1 = matrix[rowAtIndex1][colAtIndex1];
                String element2 = matrix[rowAtIndex2][colAtIndex2];
                matrix[rowAtIndex1][colAtIndex1] = element2;
                matrix[rowAtIndex2][colAtIndex2] = element1;

                printMatrix(matrix);
            }
            input = scanner.nextLine();
        }
    }

    private static boolean validateCommand(String input, int rows, int cols) {
        String[] commands = input.split("\\s+");
        String command = commands[0];

        if (!command.equals("swap")) {
            return false;
        }
        if (commands.length != 5) {
            return false;
        }

        int rowAtIndex1 = Integer.parseInt(commands[1]);
        int colAtIndex1 = Integer.parseInt(commands[2]);
        int rowAtIndex2 = Integer.parseInt(commands[3]);
        int colAtIndex2 = Integer.parseInt(commands[4]);

        if (rowAtIndex1 < 0 || rowAtIndex1 >= rows || colAtIndex1 < 0 || colAtIndex1 >= cols
                || rowAtIndex2 < 0 || rowAtIndex2 >= rows || colAtIndex2 < 0 || colAtIndex2 >= cols) {
            return false;
        }

        return true;
    }

    public static void fillRectangleMatrix(Scanner scanner, String[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
