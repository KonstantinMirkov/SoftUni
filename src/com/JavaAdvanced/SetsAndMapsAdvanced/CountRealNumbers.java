package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = readArray(scanner, "\\s+");
        Map<Double, Integer> numbersOccurrences = new LinkedHashMap<>();

        for (double number : input) {
            if (!numbersOccurrences.containsKey(number)) {
                numbersOccurrences.put(number, 1);

            } else {
                numbersOccurrences.put(number, numbersOccurrences.get(number) + 1) ;
            }
        }
        numbersOccurrences.keySet().forEach(key -> System.out.println(key + " -> " + numbersOccurrences.get(key)));
    }

    private static double[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
