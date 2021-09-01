package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        compareAndPrintMatrix(scanner);

    }

    private static void compareAndPrintMatrix(Scanner scanner) {
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArray = firstMatrix[row];
                int[] secondArray = secondMatrix[row];
                areNotEqual = firstArray.length != secondArray.length;
                if (!areNotEqual) {
                    for (int col = 0; col < firstArray.length; col++) {
                        if (firstArray[col] != secondArray[col]) {
                            areNotEqual = true;
                            break;
                        }
                    }
                }
                if (areNotEqual) {
                    break;
                }
            }
        }

        String output = areNotEqual ? "not equal" : "equal";
        System.out.println(output);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
