package com.JavaFundamentals.LabTextProcessing;

import java.util.*;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] forbiddenWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();

        for (String forbiddenWord : forbiddenWords) {
            if (input.contains(forbiddenWord)) {
                String wordOfStarsOnly = convertingWordToStars(forbiddenWord);
                input = input.replace(forbiddenWord, wordOfStarsOnly);
            }
        }
        System.out.println(input);
    }

    private static String convertingWordToStars(String word) {
        StringBuilder wordOfStarsOnly = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordOfStarsOnly.append("*");
        }
        return wordOfStarsOnly.toString();
    }
}
