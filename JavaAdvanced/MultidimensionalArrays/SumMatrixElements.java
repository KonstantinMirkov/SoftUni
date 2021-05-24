package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner, ", ");
        
        int sum = Arrays.stream(matrix)
                .mapToInt(array -> Arrays.stream(array).sum())
                .sum();

//        for (int[] array : matrix) {
//            for (int number : array) {
//                sum += number;
//            }
//        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        printMatrixSum(sum, rows, cols);
    }

    private static void printMatrixSum(int sum, int rows, int cols) {
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner, String pattern) {
        int[] rowsAndCols = readArray(scanner, pattern);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner, pattern);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
