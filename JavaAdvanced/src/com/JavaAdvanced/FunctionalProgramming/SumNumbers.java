package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());
        int sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.println("Sum = " + sum);
    }
}
