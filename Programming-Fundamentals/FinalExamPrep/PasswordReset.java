package com.JavaFundamentals.FinalExamPrep;

import java.util.*;
import java.util.stream.IntStream;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] commandParts = input.split(" ");
            String command = commandParts[0];
            switch (command) {
                case "TakeOdd":
                    password = takeOdd(password);
                    System.out.println(password);
                    break;

                case "Cut":
                    int indexToCut = Integer.parseInt(commandParts[1]);
                    int cutLength = Integer.parseInt(commandParts[2]);
                    int cuttingLength = indexToCut + cutLength;
                    password.delete(indexToCut, cuttingLength);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String toReplace = commandParts[1];
                    String replacement = commandParts[2];
                    if (password.indexOf(toReplace) != -1) {
                       password = substitute(password, toReplace,replacement);

                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }

    private static StringBuilder substitute(StringBuilder password, String toReplace, String replacement) {
        int index = -1;
        while ((index = password.lastIndexOf(toReplace)) != -1) {
            password.replace(index, index + toReplace.length(), replacement);
        }
        return password;
    }

    private static StringBuilder takeOdd(StringBuilder password) {
        StringBuilder newPassword = new StringBuilder();
        for (int index = 1; index <= password.length() - 1; index += 2) {
            char currentSymbol = password.charAt(index);
            newPassword.append(currentSymbol);
        }
        return newPassword;
    }
}