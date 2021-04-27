package com.JavaFundamentals.LabTextProcessing;

import java.util.*;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToRemove = scanner.nextLine();
        String word = scanner.nextLine();

        while (word.contains(wordToRemove)) {
            word = removeOccurrence(word,wordToRemove);

        }
        System.out.println(word);
    }

    private static String removeOccurrence(String word, String wordToRemove) {
       int beginIndex = word.indexOf(wordToRemove);
       int endIndex = beginIndex + wordToRemove.length();
       return word.substring(0,beginIndex) + word.substring(endIndex);
    }
}
