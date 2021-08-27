package com.JavaAdvanced.ExamPreparation;

import java.util.Scanner;

public class CookingJourney {
    public static int startRow = 0, startCol = 0;
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }

        boolean isWithinShop = true;

        while (money < 50 && isWithinShop) {
            String command = scanner.nextLine();
            switch (command) {
                case "up": //row -1
                    isWithinShop = move(startRow - 1, startCol, matrix);
                    break;
                case "down": //row +1
                    isWithinShop = move(startRow + 1, startCol, matrix);
                    break;
                case "left"://col -1
                    isWithinShop = move(startRow, startCol - 1, matrix);
                    break;
                case "right"://col +1
                    isWithinShop = move(startRow, startCol + 1, matrix);
                    break;
            }

        }

        String output = "";
        if (!isWithinShop){
            output = "Bad news! You are out of the pastry shop.";
        } else {
            output = "Good news! You succeeded in collecting enough money!";
        }
        System.out.println(output);
        System.out.println("Money: " + money);
        printPastryShop(matrix);


    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';
        if (isBakerOutOfBounds(newRow, newCol, matrix)) {
            return false;
        }
        char symbol = matrix[newRow][newCol];
        if (Character.isDigit(symbol)) {
            money += symbol - '0';

        }else if (symbol == 'P') {
            matrix[newRow][newCol] = '-';
            int [] secondPillarLocation = findSecondPillarInShop(matrix);
            newRow = secondPillarLocation[0];
            newCol = secondPillarLocation[1];
        }

        matrix[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
        return true;

    }

    private static int[] findSecondPillarInShop(char[][] matrix) {
        int[] indexes = null;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P'){
                    indexes = new int [] {row, col};
                    break;
                }
            }
            if (indexes != null){
                break;
            }
        }
        return indexes;
    }

    private static void printPastryShop(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isBakerOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }
}
