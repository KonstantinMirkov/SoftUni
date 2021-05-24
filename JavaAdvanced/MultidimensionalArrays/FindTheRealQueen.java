package com.JavaAdvanced.MultidimensionalArrays;

import java.util.*;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> queensPositions = new ArrayList<>();
        List<Integer> realQueens = new ArrayList<>();

        String[][] chessBoard = new String[8][8];
        for (int rows = 0; rows < 8; rows++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < 8; cols++) {
                chessBoard[rows][cols] = line[cols];
                if (chessBoard[rows][cols].charAt(0) == 'q') {
                    queensPositions.add(rows);
                    queensPositions.add(cols);
                }
            }
        }
        whileQueensPositionsAreNotEmpty(queensPositions, realQueens, chessBoard);

        print(realQueens);
    }


    private static void whileQueensPositionsAreNotEmpty(List<Integer> queensPositions, List<Integer> realQueens, String[][] chessBoard) {
        while (!queensPositions.isEmpty()) {
            int row = queensPositions.get(0);
            int col = queensPositions.get(1);

            boolean queenIsFake = false;

            for (int i = 2; i < queensPositions.size(); i++) {
                if (queensPositions.get(i) == row || queensPositions.get(i) == col) {
                    queenIsFake = true;
                    break;
                }
            }

            queenIsFake = downAndRight(chessBoard, row, col, queenIsFake);

            queenIsFake = upAndLeft(chessBoard, row, col, queenIsFake);

            queenIsFake = downAndLeft(chessBoard, row, col, queenIsFake);

            queenIsFake = upAndRight(chessBoard, row, col, queenIsFake);
            if (!queenIsFake) {
                realQueens.add(row);
                realQueens.add(col);
            }
            queensPositions.remove(0);
            queensPositions.remove(0);
        }
    }

    private static boolean upAndRight(String[][] chessBoard, int row, int col, boolean queenIsFake) {
        if (!queenIsFake) { //UP & RIGHT
            int row4 = row;
            int col4 = col;

            for (int i = 1; i < 8; i++) {
                row4 -= 1;
                col4 += 1;
                if (row4 <= 0 || col4 >= 8) {
                    break;
                }
                if (chessBoard[row4][col4].charAt(0) == 'q') {
                    queenIsFake = true;
                    break;
                }
            }

        }
        return queenIsFake;
    }

    private static boolean downAndLeft(String[][] chessBoard, int row, int col, boolean queenIsFake) {
        if (!queenIsFake) {  //DOWN & LEFT
            int row3 = row;
            int col3 = col;

            for (int i = 1; i < 8; i++) {
                row3 += 1;
                col3 -= 1;
                if (row3 >= 8 || col3 <= 0) {
                    break;
                }
                if (chessBoard[row3][col3].charAt(0) == 'q') {
                    queenIsFake = true;
                    break;
                }
            }

        }
        return queenIsFake;
    }

    private static boolean upAndLeft(String[][] chessBoard, int row, int col, boolean queenIsFake) {
        if (!queenIsFake) { // UP & LEFT
            int row2 = row;
            int col2 = col;

            for (int i = 0; i < 8; i++) {
                row2 -= 1;
                col2 -= 1;
                if (row2 <= 0 || col2 <= 0) {
                    break;
                }
                if (chessBoard[row2][col2].charAt(0) == 'q') {
                    queenIsFake = true;
                    break;
                }
            }
        }
        return queenIsFake;
    }

    private static boolean downAndRight(String[][] chessBoard, int row, int col, boolean queenIsFake) {
        if (!queenIsFake) { //DOWN & RIGHT
            int row1 = row;
            int col1 = col;

            for (int i = 1; i < 8; i++) {
                row1 += 1;
                col1 += 1;
                if (row1 >= 8 || col1 >= 8) {
                    break;
                }
                if (chessBoard[row1][col1].charAt(0) == 'q') {
                    queenIsFake = true;
                    break;
                }
            }

        }
        return queenIsFake;
    }

    private static void print(List<Integer> realQueens) {
        if (!realQueens.isEmpty()) {
            System.out.println(realQueens.get(0) + " " + realQueens.get(1));
        }
    }
}
