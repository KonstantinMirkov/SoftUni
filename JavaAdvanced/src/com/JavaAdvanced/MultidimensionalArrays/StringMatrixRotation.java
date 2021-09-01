package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        String input = scanner.nextLine();
        List<String> matrixRows = new ArrayList<>();
        int maxWordLength = input.length();
        while (!input.equals("END")) {
            matrixRows.add(input);
            if (input.length() > maxWordLength) {
                maxWordLength = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = matrixRows.size();
        int cols = maxWordLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < matrixRows.get(row).length()) {
                    matrix[row][col] = matrixRows.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        printMatrix(angleRotation, rows, cols, matrix);
    }

    private static void printMatrix(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            rotationAngle90(rows, cols, matrix);
        } else if (angleRotation == 180) {
            rotationAngle180(rows, cols, matrix);
        } else if (angleRotation == 270) {
            rotationAngle270(rows, cols, matrix);
        } else if (angleRotation == 0) {
            rotationAngle0(rows, cols, matrix);
        }
    }

    private static void rotationAngle0(int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAngle270(int rows, int cols, char[][] matrix) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAngle180(int rows, int cols, char[][] matrix) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAngle90(int rows, int cols, char[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
