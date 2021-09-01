package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputOfNumbers = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(inputOfNumbers[0]);
        int upper = Integer.parseInt(inputOfNumbers[1]);

        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> filter = getFilter(evenOrOdd);

        for (int number = lower; number <= upper; number++) {
            if (filter.test(number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static Predicate<Integer> getFilter(String evenOrOdd) {
        if (evenOrOdd.equals("even")) {
            return x -> x % 2 == 0;
        } else {
            return x -> x % 2 != 0;
        }
    }
}
