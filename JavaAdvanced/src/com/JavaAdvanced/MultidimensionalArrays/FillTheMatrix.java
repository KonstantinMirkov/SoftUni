package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int sidesSize = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[sidesSize][sidesSize];

        int startNumber = 1;
        if (pattern.equals("A")) {
            fillPatternA(sidesSize, matrix, startNumber);
        } else if (pattern.equals("B")) {
            fillPatternB(sidesSize, matrix, startNumber);
        }
        printMatrix(matrix);
    }

    private static void fillPatternA(int sidesSize, int[][] matrix, int startNumber) {
        for (int col = 0; col < sidesSize; col++) {
            for (int row = 0; row < sidesSize; row++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    private static void fillPatternB(int sidesSize, int[][] matrix, int startNumber) {
        for (int col = 0; col < sidesSize; col++) {
            //Четен ред
            if (col % 2 == 0) {
                for (int row = 0; row < sidesSize; row++) {
                    matrix[row][col] = startNumber++;
                }

            }
            //Нечетен ред
            else {
                for (int row = sidesSize - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
