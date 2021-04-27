package com.JavaFundamentals.TextProcessingExercises;

import java.util.*;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalSum = 0;
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        for (String word : words) {
            double sumOfWord = getWordSum(word);
            totalSum += sumOfWord;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getWordSum(String word) {
        double sumOfResult = 0;
        char firstLetter = word.charAt(0);
        char secondLetter = word.charAt(word.length() - 1);
        double number = Double.parseDouble(word.substring(1, word.length() - 1));

        
        if (Character.isUpperCase(firstLetter)) {
            sumOfResult = number / (firstLetter - 64);
            number = sumOfResult;
        } else {
            sumOfResult = number * (firstLetter - 96);
            number = sumOfResult;
        }
        if (Character.isUpperCase(secondLetter)) {
            sumOfResult = number - (secondLetter - 64);
        } else {
            sumOfResult = number + (secondLetter - 96);
        }
        return sumOfResult;
    }
}
