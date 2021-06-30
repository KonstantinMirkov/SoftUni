package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readList(scanner, "\\s+");
        Comparator<Integer> comparator = ((x, y) -> {
            if (x % 2 == 0 && y % 2 != 0) {
                return -1;
            } else if (x % 2 != 0 && y % 2 == 0) {
                return 1;
            } else if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                if (x <= y) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        });
        numbers.sort(comparator);
        numbers.forEach(n -> System.out.print(n + " "));
    }


    private static List<Integer> readList(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
