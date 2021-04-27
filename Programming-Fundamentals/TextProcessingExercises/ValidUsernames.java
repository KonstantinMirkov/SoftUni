package com.JavaFundamentals.TextProcessingExercises;

import java.util.*;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] usernames = text.split(", ");

        for (String username : usernames) {
            if(ifIsValidUsername(username)){
                System.out.println(username);
            }
        }
    }

    private static boolean ifIsValidUsername(String username) {

        if (TheUsernameLength(username)){
            return false;
        }

        for (int index = 0; index <= username.length() - 1; index++) {
            char currentSymbol = username.charAt(index);
            if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '-' && currentSymbol != '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean TheUsernameLength(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return true;
        }
        return false;
    }
}
