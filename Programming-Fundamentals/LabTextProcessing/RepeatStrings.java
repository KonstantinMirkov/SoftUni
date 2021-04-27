package com.JavaFundamentals.LabTextProcessing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            String repeatedWord = repeatWord(word, word.length());
            Print(repeatedWord);
        }
    }



    private static String repeatWord(String word, int numberOfRepeats) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfRepeats; i++) {
            result.append(word);
        }
        return result.toString();
    }
    private static void Print(String repeatedWord) {
        System.out.print(repeatedWord);
    }
}
