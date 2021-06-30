package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playersData = new LinkedHashMap<>();
        getPlayersCards(scanner, input, playersData);
        print(playersData);
    }

    private static void getPlayersCards(Scanner scanner, String input, Map<String, Set<String>> playersData) {
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] beginCards = input.split(": ")[1].split(", ");

            Set<String> cards = new LinkedHashSet<>();
            Collections.addAll(cards, beginCards);

            if (!playersData.containsKey(name)) {
                playersData.put(name, cards);
            } else {
                Set<String> currentCards = playersData.get(name);
                currentCards.addAll(cards);
                playersData.put(name, currentCards);
            }
            input = scanner.nextLine();
        }
    }

    private static void print(Map<String, Set<String>> players) {
        for (var entry : players.entrySet()) {
            String player = entry.getKey();
            int points = getCardPoints(entry.getValue());
            System.out.println(player + ": " + points);
        }
    }

    private static int getCardPoints(Set<String> cards) {
        int sum = 0;
        Map<Character, Integer> pointsValues = getPointsValues();
        for (String card : cards) {
            int points;

            if (card.contains("10")) {
                char strength = card.charAt(2);
                points = 10 * pointsValues.get(strength);
            } else {
                char number = card.charAt(0);
                char strength = card.charAt(1);
                points = pointsValues.get(strength) * pointsValues.get(number);

            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getPointsValues() {
        Map<Character, Integer> points = new LinkedHashMap<>();

        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}
