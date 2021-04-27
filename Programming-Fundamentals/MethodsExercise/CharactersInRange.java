package com.JavaFundamentals.MethodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char firstChar = sc.nextLine().charAt(0);
        char secondChar = sc.nextLine().charAt(0);

        printChars(firstChar, secondChar);
    }

    static void printChars(char firstChar, char secondChar) {
        if (firstChar < secondChar) {
            for (char i = (char) (firstChar + 1); i < secondChar; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (secondChar + 1); i < firstChar; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
