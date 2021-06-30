package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner, "\\s+");

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] commands = input.split("\\s+");

            int row = Integer.parseInt(commands[0]);
            int col = Integer.parseInt(commands[1]);
            int radius = Integer.parseInt(commands[2]);


            removeUpAndDown(matrix, row, col, radius);

            removeLeftAndRight(matrix, row, col, radius);

            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(element -> System.out.print(element + " "));
            System.out.println();
        }
    }

    private static void removeLeftAndRight(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = col + radius; i >= col - radius; i--) {
            if (isInsideMatrix(row, i, matrix)){
                matrix.get(row).remove(i);
            }
        }
    }

    private static void removeUpAndDown(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = row - radius; i <= row + radius; i++) {
            if (isInsideMatrix(i, col, matrix) && i != row){
                matrix.get(i).remove(col);
            }
        }
    }

    private static boolean isInsideMatrix( int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }



    public static void fillMatrix(List<List<Integer>> matrix, int cols, int rows) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
