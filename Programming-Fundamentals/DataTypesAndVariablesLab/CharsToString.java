package com.JavaFundamentals.DataTypesAndVariablesLab;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String input2 = scanner.nextLine();
        String input3 = scanner.nextLine();

        System.out.printf("%s%s%s", input , input2 , input3);

    }
}
