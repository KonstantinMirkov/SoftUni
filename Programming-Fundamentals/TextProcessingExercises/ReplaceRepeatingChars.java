package com.JavaFundamentals.TextProcessingExercises;

import java.util.*;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            characterList.add(charArray[i]);
        }

        for (int i = 1; i < characterList.size(); i++) {
            char previousChar = characterList.get(i - 1);
            char currentChar = characterList.get(i);

            if (previousChar == currentChar){
                characterList.remove(i);
                i--;
            }
        }
        print(characterList);
    }

    private static void print(List<Character> characterList) {
        for (Character character : characterList) {
            System.out.print(character);
        }
    }
}
