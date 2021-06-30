package com.JavaAdvanced;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        //Function <Приема, Връща>
        Function<Integer, Integer> calculateSum = x -> x + x;

        //Consumer<Приема> -> връща void
        Consumer<Integer> calculateNumber = n -> n = n + 5;
        Consumer<Integer> printNumber = System.out::println;
        printNumber.accept(5);

        //Suppler<Връща>
        Supplier<String> getName = () -> String.valueOf(new Random());

        //Predicate<Приема> -> връща true/false
        Predicate<Integer> isOdd = n -> n % 2 == 1;
        boolean isOddNumber = isOdd.test(5); //true
        isOddNumber = isOdd.test(6); //false

        //BiFunction<Приема1, Приема2, Връща>
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        System.out.println(sum.apply(3, 4));

        // Comparator<Приема> - > сравнява
        Comparator<Integer> comparatorSum = (x, y) -> x + y;
    }

    public static void formatNumbers() {
        Function<IntStream, String> formatNumbers = str -> str
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static int[][] fillSquareMatrix(Scanner scanner, String pattern) {
        int[] rowsAndCols = readArray(scanner, pattern);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, pattern);
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

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void fillRectangleMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static LinkedHashSet<Integer> readSet(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static List<Integer> readList(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Deque<Integer> readDeque(Scanner scanner, String pattern) {
       return Arrays.stream(scanner.nextLine().split(pattern))
               .map(Integer::parseInt)
               .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
