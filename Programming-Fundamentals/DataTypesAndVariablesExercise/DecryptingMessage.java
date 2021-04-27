package com.JavaFundamentals.DataTypesAndVariablesExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int key = Integer.parseInt(sc.nextLine());
        int lines = Integer.parseInt(sc.nextLine());
        char currentChar = ' ';
        String decryptedMessage = "";

        for (int i = 1; i <= lines; i++){
            currentChar = sc.nextLine().charAt(0);
            currentChar = (char) (currentChar + key);

            decryptedMessage = decryptedMessage.concat(Character.toString(currentChar));
        }
        System.out.println(decryptedMessage);
    }
}
