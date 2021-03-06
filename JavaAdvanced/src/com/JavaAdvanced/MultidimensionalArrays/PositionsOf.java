package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        findAndPrintMatrix(scanner, rows, matrix);
    }

    private static void findAndPrintMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] commands = scanner.nextLine().split("\\s+");
            for (int i = 0; i < commands.length; i++) {
                int number = Integer.parseInt(commands[i]);
                matrix[row][i] = number;
            }
        }
        int number = Integer.parseInt(scanner.nextLine());

        List<int[]> positions = new ArrayList<>();


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    int[] indexes = new int[]{row, col};
                    positions.add(indexes);
                }
            }
        }
        printMatrix(positions);
    }

    private static void printMatrix(List<int[]> positions) {
        if (positions.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] position : positions) {
                System.out.println(position[0] + " " + position[1]);
            }
        }
    }


    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
