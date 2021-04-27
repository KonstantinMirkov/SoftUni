package com.JavaFundamentals.MapsLambdaAndStreamAPILab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        Map<Double, Integer> treeOfNumbers = new TreeMap<>();
        double[] arrayOfNumbers = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();
        for (Double number : arrayOfNumbers) {
            if (!treeOfNumbers.containsKey(number)) {
                treeOfNumbers.put(number, 1);
            } else {
                int occurrences = treeOfNumbers.get(number);
                occurrences++;
                treeOfNumbers.put(number, occurrences);
            }

        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> entry : treeOfNumbers.entrySet()) {
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());
        }
    }
}
