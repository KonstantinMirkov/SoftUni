package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner, "\\s+");
        Consumer<int[]> printSmallestNumber = n -> System.out.println(Arrays.stream(n).min().orElse(0));
        printSmallestNumber.accept(numbers);


    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
