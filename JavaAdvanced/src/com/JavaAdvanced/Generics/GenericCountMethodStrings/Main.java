package com.JavaAdvanced.Generics.GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<String> inputs = new Box<>();

        int inputsCount = Integer.parseInt(scanner.nextLine());
        while (inputsCount-- > 0) {
            String text = scanner.nextLine();

            inputs.add(text);
        }
        String element = scanner.nextLine();

        System.out.println(inputs.count(element));
    }
}
