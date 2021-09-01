package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt(), cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];

        matrixInfo(rows, cols, matrix);
        printMatrix(matrix);
    }

    private static void matrixInfo(int rows, int cols, String[][] matrix) {
        char startLetter = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "" + startLetter + (char) (startLetter + col) + startLetter;
            matrix[row][col] = palindrome;
            }
            startLetter = (char) (startLetter + 1);
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
