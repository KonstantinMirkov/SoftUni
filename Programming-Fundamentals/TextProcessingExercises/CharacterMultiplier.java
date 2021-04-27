package com.JavaFundamentals.TextProcessingExercises;

import java.util.*;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.println(multiplyCharacters(input[0],input[1]));
    }
    public static long multiplyCharacters(String firstString, String secondString) {
        char[] firstWord = firstString.toCharArray();
        char[] secondWord = secondString.toCharArray();
        long sum = 0;
        long temporarySum = 0;
        int shorterWord = Math.min(firstWord.length, secondWord.length);
        int longestWord = Math.max(firstWord.length, secondWord.length);

        for (int i = 0; i < shorterWord; i++) {
            temporarySum = (int) firstWord[i] * (int) secondWord[i];
            sum += temporarySum;
        }

        if (firstWord.length < secondWord.length) {
            for (int i = shorterWord; i <= longestWord - 1; i++) {
                sum += secondWord[i];
            }
        } else if (firstWord.length > secondWord.length) {
            for (int i = shorterWord; i <= longestWord - 1; i++)
            {
                sum += firstWord[i];
            }
        }
        return sum;

    }
}
