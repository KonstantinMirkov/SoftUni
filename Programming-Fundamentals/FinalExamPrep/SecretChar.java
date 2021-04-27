package com.JavaFundamentals.FinalExamPrep;

import java.util.*;

public class SecretChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String concealedMessage = scanner.nextLine();
        String input = scanner.nextLine();
        concealedMessage = iteratingBeforeReveal(scanner, concealedMessage, input);
        System.out.println("You have a new text message: " + concealedMessage);
    }

    private static String iteratingBeforeReveal(Scanner scanner, String concealedMessage, String input) {
        while (!input.equals("Reveal")) {
            String[] commands = input.split(":\\|:");
            String command = commands[0];
            switch (command) {
                case "InsertSpace":
                    int indexToInsertSpace = Integer.parseInt(commands[1]);
                    concealedMessage = insertSpace(concealedMessage, indexToInsertSpace);
                    System.out.println(concealedMessage);
                    break;
                case "Reverse":
                    String substring = commands[1];
                    if (concealedMessage.contains(substring)) {
                        concealedMessage = cutReverseAndConcat(concealedMessage, substring);
                        System.out.println(concealedMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String subString = commands[1];
                    String replacement = commands[2];
                    concealedMessage = changeAll(concealedMessage, subString, replacement);
                    System.out.println(concealedMessage);

                    break;
            }
            input = scanner.nextLine();
        }
        return concealedMessage;
    }


    private static String insertSpace(String concealedMessage, int indexToInsertSpace) {
        concealedMessage = concealedMessage.substring(0, indexToInsertSpace) + " " + concealedMessage.substring(indexToInsertSpace);
        return concealedMessage;
    }
    private static String cutReverseAndConcat(String concealedMessage, String substring) {

        concealedMessage = concealedMessage.replaceFirst((substring), "")
                .concat(new StringBuilder(substring).reverse().toString());
        return concealedMessage;
    }
    private static String changeAll(String concealedMessage, String subString, String replacement) {
        concealedMessage = concealedMessage.replace(subString, replacement);
        return concealedMessage;
    }


}