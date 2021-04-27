package com.JavaFundamentals.FinalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String numberRegex = "\\d";
        String emojiRegex = "(?<separator>[\\\\*:])\\1(?<emojiName>[A-Z][a-z][a-z]+)\\1\\1";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(input);

        List<Integer> numbersList = new ArrayList<>();

        while(numberMatcher.find()){
            int number =  Integer.parseInt(numberMatcher.group());
            numbersList.add(number);
        }

        long coolness = numbersList.stream().reduce(1, (a, b) -> a * b);
        System.out.printf("Cool threshold: %d%n", coolness);

        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(input);

        List<String> theCoolEmojis = new ArrayList<>();

        int countOfEmojis = 0;
        while(emojiMatcher.find()){
            countOfEmojis++;
            String separator = emojiMatcher.group("separator");
            String emojiText = emojiMatcher.group("emojiName");
            if(isEmojiCool(emojiText, coolness)){
                String fullEmoji = separator + separator + emojiText + separator + separator;
                theCoolEmojis.add(fullEmoji);
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfEmojis);
        theCoolEmojis.forEach(System.out::println);
    }

    public static boolean isEmojiCool(String emojiText, long coolnessThreshold){
        int emojiCoolness = 0;
        for (int i = 0; i < emojiText.length(); i++) {
            char emojiCharacter = emojiText.charAt(i);
            emojiCoolness+=emojiCharacter;
        }
        return emojiCoolness >= coolnessThreshold;
    }
}
