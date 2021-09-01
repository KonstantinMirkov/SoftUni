package com.JavaAdvanced.Generics.GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Double> inputs = new Box<>();

        int inputsCount = Integer.parseInt(scanner.nextLine());
        while (inputsCount-- > 0) {
            double inputOfDoubles = Double.parseDouble(scanner.nextLine());

            inputs.add(inputOfDoubles);
        }
        double element = Double.parseDouble(scanner.nextLine());

        System.out.println(inputs.count(element));
    }
}
