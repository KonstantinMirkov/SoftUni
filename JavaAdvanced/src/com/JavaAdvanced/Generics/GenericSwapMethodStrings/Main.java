package com.JavaAdvanced.Generics.GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Integer> inputs = new Box<>();

        int inputsCount = Integer.parseInt(scanner.nextLine());
        while (inputsCount-- > 0) {
            int inputOfNumbers = Integer.parseInt(scanner.nextLine());

            inputs.add(inputOfNumbers);
        }
        String[] indexesToSwap = scanner.nextLine().split("\\s+");
        int index1 = Integer.parseInt(indexesToSwap[0]);
        int index2 = Integer.parseInt(indexesToSwap[1]);

        inputs.swap(index1, index2);

        System.out.println(inputs);
    }
}

