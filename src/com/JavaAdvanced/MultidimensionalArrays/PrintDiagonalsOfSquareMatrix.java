package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }

        printDiagonals(matrixSize, matrix);
    }

    private static void printDiagonals(int matrixSize, int[][] matrix) {
        int row = 0, col = 0;
        while (row < matrixSize && col < matrixSize) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();
        row = matrixSize - 1;
        col = 0;
        while (row >= 0  && col < matrixSize) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
