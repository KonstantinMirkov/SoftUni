package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();

        countSymbols(input, symbols);
        print(symbols);
    }

    private static void countSymbols(String input, Map<Character, Integer> symbols) {
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (!symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, 1);
            } else {
                symbols.put(currentSymbol, symbols.get(currentSymbol) + 1);
            }
        }
    }

    private static void print(Map<Character, Integer> symbols) {
        for (var entry : symbols.entrySet()) {
            Character symbol = entry.getKey();
            System.out.println(symbol + ": " + entry.getValue() + " time/s");
        }
    }
}
