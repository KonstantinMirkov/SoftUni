package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }

        int[] indexes = readArray(scanner, "\\s+");

        int wrongValue = matrix[indexes[0]][indexes[1]];

        List<int[]> fixedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int correctValue = calculateRightValue(matrix, row, col, wrongValue);
                    fixedValues.add(new int[]{row, col, correctValue});
                }
            }
        }
        fixedValues.forEach(fixedValue -> matrix[fixedValue[0]][fixedValue[1]] = fixedValue[2]);

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateRightValue(int[][] matrix, int row, int col, int wrongValue) {
        int correctValue = 0;
// sum - up, down, left and right
        if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue) {
            correctValue += matrix[row - 1][col];// up
        }
        if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
            correctValue += matrix[row + 1][col]; // down
        }
        if (isInBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue) {
            correctValue += matrix[row][col - 1]; // left
        }
        if (isInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue) {
            correctValue += matrix[row][col + 1]; // right
        }

        return correctValue;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row < matrix.length && row >= 0 && col < matrix[row].length && col >= 0;
    }

    private static boolean isOutOfBounds(int[][] matrix, int row, int col) {
        return !isInBounds(matrix, row, col);
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
