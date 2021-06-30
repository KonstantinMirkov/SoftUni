package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readList(scanner, "\\s+");

        Consumer<List<Integer>> printSmallestNumber = element -> {
            int minElement = Integer.MAX_VALUE;
            for (int number : element) {
                if (number < minElement) {
                    minElement = number;
                }
            }
            System.out.println(element.lastIndexOf(minElement));
        };

        printSmallestNumber.accept(numbers);
    }

    private static List<Integer> readList(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
