package com.JavaFundamentals.MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    static int getMax(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    static char getMax(char first, char second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dataType = sc.nextLine();

        switch (dataType) {
            case "int":
                int firstInt = Integer.parseInt(sc.nextLine());
                int secondInt = Integer.parseInt(sc.nextLine());
                int resultInt = getMax(firstInt, secondInt);
                System.out.println(resultInt);
                break;
            case "char":
                char firstChar = sc.nextLine().charAt(0);
                char secondChar = sc.nextLine().charAt(0);
                char resultChar = getMax(firstChar, secondChar);
                System.out.println(secondChar);
                break;
            case "string":
                String firstString = sc.nextLine();
                String secondString = sc.nextLine();
                String resultString = getMax(firstString, secondString);
                System.out.println(resultString);
                break;
        }

    }
}
