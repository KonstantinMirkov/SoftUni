package com.JavaFundamentals.LabTextProcessing;

import java.util.*;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder letters = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        String input = scanner.nextLine();
        IfLettersOrNumbersOrSymbols(letters, numbers, symbols, input);
        Print(letters, numbers, symbols);
    }

    private static void IfLettersOrNumbersOrSymbols(StringBuilder letters, StringBuilder numbers, StringBuilder symbols, String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(Character.isDigit(currentSymbol)){
                numbers.append(currentSymbol);
            }else if(Character.isAlphabetic(currentSymbol)){
                letters.append(currentSymbol);
            }else{
                symbols.append(currentSymbol);
            }
        }
    }

    private static void Print(StringBuilder letters, StringBuilder numbers, StringBuilder symbols) {
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(symbols);
    }
}
