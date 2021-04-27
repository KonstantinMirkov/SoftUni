package com.JavaFundamentals.FinalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regex = "([\\@\\#])(?<WordOne>[a-zA-Z]{3,})(\\1)(\\1)(?<WordTwo>[a-zA-Z]{3,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorWords = new ArrayList<>();

        int countPairs = 0;
        while (matcher.find()) {
            countPairs++;
            String firstWord = matcher.group("WordOne");
            String secondWord = new StringBuilder(matcher.group("WordTwo")).reverse().toString();
            if (firstWord.equals(secondWord)) {
                mirrorWords.add(firstWord + " <=> " + matcher.group("WordTwo"));
            }
        }
        if (countPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countPairs);
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", mirrorWords));
        }
    }
}
