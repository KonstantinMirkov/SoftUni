package com.JavaFundamentals.FinalExamPrep;

import java.util.*;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder key = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] commandsArray = command.split(">>>");
            String commandName = commandsArray[0];
            switch (commandName) {
                case "Contains":
                    String wordToSearchFor = commandsArray[1];
                    if (key.indexOf(wordToSearchFor) != -1) {
                        System.out.printf("%s contains %s%n", key, wordToSearchFor);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String flip = commandsArray[1];
                    int flipStartIndex = Integer.parseInt(commandsArray[2]);
                    int flipEndIndex = Integer.parseInt(commandsArray[3]);
                    for (int i = flipStartIndex; i < flipEndIndex; i++) {
                        char currentChar = key.charAt(i);
                        if (flip.equals("Lower")) {
                            key.setCharAt(i, Character.toLowerCase(currentChar));
                        } else {
                            key.setCharAt(i, Character.toUpperCase(currentChar));
                        }
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    int sliceStartIndex = Integer.parseInt(commandsArray[1]);
                    int sliceEndIndex = Integer.parseInt(commandsArray[2]);
                    key.delete(sliceStartIndex, sliceEndIndex);
                    System.out.println(key);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", key);
    }
}
