package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .toArray();

        Function<IntStream, String> formatNumbers = str -> str
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        printEvenNumbers(numbers, formatNumbers);

    }

    private static void printEvenNumbers(int[] numbers, Function<IntStream, String> formatNumbers) {
        String outPrint1 = formatNumbers.apply(Arrays.stream(numbers));
        System.out.print(outPrint1);
        String outPrint2 = formatNumbers.apply(Arrays.stream(numbers).sorted());
        System.out.println();
        System.out.println(outPrint2);
    }
}
