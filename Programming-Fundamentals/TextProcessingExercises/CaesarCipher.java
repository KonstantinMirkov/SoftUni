package com.JavaFundamentals.TextProcessingExercises;

import java.util.*;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder encryptedInput = new StringBuilder();

        for (int i = 0; i <= input.length() - 1; i++) {
            char currentSymbol = input.charAt(i);
            encryptedInput.append((char) (currentSymbol + 3));
        }
        System.out.println(encryptedInput.toString());
    }
}
