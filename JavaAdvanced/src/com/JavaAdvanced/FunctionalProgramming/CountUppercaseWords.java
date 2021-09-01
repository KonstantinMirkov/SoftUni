package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> wordsInUppercase = s -> Character.isUpperCase(s.charAt(0));
        String[] inputOfWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(wordsInUppercase)
                .toArray(String[]::new);

        System.out.println(inputOfWords.length);

        Arrays.stream(inputOfWords).forEach(System.out::println);
    }
}
