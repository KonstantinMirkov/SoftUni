package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Voina_NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = readSet(scanner.nextLine(), "\\s+");
        Set<Integer> secondDeck = readSet(scanner.nextLine(), "\\s+");

        int rounds = 50;

        while (rounds-- > 0) {
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        print(firstDeck, secondDeck);
    }

    private static void print(Set<Integer> firstDeck, Set<Integer> secondDeck) {
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        }else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static int getFirst(Set<Integer> set) {
       return set.stream().findFirst().orElse(0);
    }

    public static LinkedHashSet<Integer> readSet(String input, String pattern) {
        return Arrays.stream(input.split(pattern))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
