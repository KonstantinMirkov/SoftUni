package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<String, Double> mapWithVAT = s -> Double.parseDouble(s) * 1.2;

        System.out.println("Prices with VAT:");
         Arrays.stream(scanner.nextLine()
                 .split(", "))
                 .map(mapWithVAT)
                 .forEach(n -> System.out.printf("%.2f%n", n));

    }
}
