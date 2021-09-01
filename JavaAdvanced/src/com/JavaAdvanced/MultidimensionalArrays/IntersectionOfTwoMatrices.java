package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            firstMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        for (int row = 0; row < rows; row++) {

            secondMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        char[][] finalMatrix = new char[rows][cols];
        findIntersected(rows, cols, firstMatrix, secondMatrix, finalMatrix);
        printMatrix(finalMatrix);
    }

    private static void findIntersected(int rows, int cols, char[][] firstMatrix, char[][] secondMatrix, char[][] finalMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstSSymbol = firstMatrix[row][col];
                char secondSSymbol = secondMatrix[row][col];
                finalMatrix[row][col] = firstSSymbol == secondSSymbol ? firstSSymbol : '*';
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
