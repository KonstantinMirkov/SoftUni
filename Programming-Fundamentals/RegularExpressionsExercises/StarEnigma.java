package com.JavaFundamentals.RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String encryptedMessage = scanner.nextLine();
            int countSpecialLetters = getSpecialLetters(encryptedMessage);
            String decryptedMessage = getDecryptedMessage(encryptedMessage, countSpecialLetters);

            String regex = "@(?<planetName>[A-Za-z]+)[^@:!\\->]*:(?<population>\\d+)[^@:!\\->]*!(?<attack>[A|D])![^@:!\\->]*\\->(?<soldier>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String planet = matcher.group("planetName");
                String attackType = matcher.group("attack");
                if (attackType.equals("A")) {
                    attacked.add(planet);
                } else if (attackType.equals("D")) {
                    destroyed.add(planet);
                }
            }

        }

        print(attacked, destroyed);
    }

    private static void print(List<String> attacked, List<String> destroyed) {
        Collections.sort(attacked);
        Collections.sort(destroyed);

        System.out.println("Attacked planets: " + attacked.size());
        if (!attacked.isEmpty()) {
            attacked.forEach(p -> System.out.println("-> " + p));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        if (!destroyed.isEmpty()) {
            destroyed.forEach(p -> System.out.println("-> " + p));
        }
    }

    private static String getDecryptedMessage(String encryptedMessage, int countSpecialLetters) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int index = 0; index < encryptedMessage.length(); index++) {
            char currentSymbol = encryptedMessage.charAt(index);
            decryptedMessage.append((char) (currentSymbol - countSpecialLetters));
        }
        return decryptedMessage.toString();
    }

    private static int getSpecialLetters(String encryptedMessage) {
        int count = 0;
        String regexForSpecialLetters = "[SsTtAaRr]";
        Pattern pattern = Pattern.compile(regexForSpecialLetters);
        Matcher matcher = pattern.matcher(encryptedMessage);

        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
