package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputtedText = sc.nextLine();
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        SymbolsCounter(inputtedText, symbolsCount);
        Print(symbolsCount);
    }

    private static void SymbolsCounter(String inputtedText, Map<Character, Integer> symbolsCount) {
        for (int index = 0; index < inputtedText.length() ; index++) {
            char currentSymbol = inputtedText.charAt(index);
            if (currentSymbol == ' ') {
                continue;
            }
            if (!symbolsCount.containsKey(currentSymbol)) {
                symbolsCount.put(currentSymbol, 1);
            } else {
                symbolsCount.put(currentSymbol, symbolsCount.get(currentSymbol) + 1);
            }
        }
    }

    private static void Print(Map<Character, Integer> symbolsCount) {
        for (Map.Entry<Character, Integer> entryForSymbolsCount : symbolsCount.entrySet()) {
            System.out.println(entryForSymbolsCount.getKey() + " -> " + entryForSymbolsCount.getValue());
        }
    }
}
