package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = readArray(scanner, "\\s+");

        IntStream.rangeClosed(1, n).filter(i -> Divider(numbers, i)).forEach(i -> System.out.print(i + " "));
    }

    private static boolean Divider(int[] dividers, int number) {
        boolean result = true;

        for (var divider : dividers) {
            if (number % divider != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
