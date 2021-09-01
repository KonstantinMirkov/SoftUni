package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner, "\\s+");

        Function<int[], int[]> addNumber = n -> Arrays.stream(n).map(e -> e += 1).toArray();
        Function<int[], int[]> multiplyNumber = n -> Arrays.stream(n).map(e -> e *= 2).toArray();
        Function<int[], int[]> subtractNumber = n -> Arrays.stream(n).map(e -> e -= 1).toArray();
        Consumer<int[]> print = n -> Arrays.stream(n).forEach(e -> System.out.print(e + " "));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = addNumber.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyNumber.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractNumber.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;

            }
            input = scanner.nextLine();
        }
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
