package com.JavaAdvanced.Generics.GenericBox;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<String> inputs = new Box<>();

        int inputsCount = Integer.parseInt(scanner.nextLine());
        while(inputsCount-- > 0){
            String input = scanner.nextLine();

            inputs.add(input);
        }

        System.out.println(inputs);
    }
}
