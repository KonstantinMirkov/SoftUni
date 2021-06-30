package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        fillSquareMatrix(scanner, "\\s+", matrix, matrixSize);

        sumDiagonals(matrixSize, matrix);
    }

    private static void sumDiagonals(int matrixSize, int[][] matrix) {
        int sumD1 = 0;
        int sumD2 = 0;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (row == col) {
                    sumD1 += matrix[row][col];
                }
                if (col == matrixSize - 1 - row) {
                    sumD2 += matrix[row][col];
                }
            }
        }
        System.out.println(Math.abs(sumD1 - sumD2));
    }

    private static void fillSquareMatrix(Scanner scanner, String pattern, int[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, pattern);
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }
}
