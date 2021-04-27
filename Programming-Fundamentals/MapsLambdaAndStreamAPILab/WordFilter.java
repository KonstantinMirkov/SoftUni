package com.JavaFundamentals.MapsLambdaAndStreamAPILab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordsToFilter = scanner.nextLine().split(" ");

        Arrays.stream(wordsToFilter)
                .filter(word -> word.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
