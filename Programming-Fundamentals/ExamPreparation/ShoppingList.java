package com.JavaFundamentals.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> products = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split("\\s+");
            String commandCases = commands[0];
            String currentProduct = commands[1];
            switch (commandCases) {
                case "Urgent":
                    if (products.contains(currentProduct)) {
                        break;
                    } else {
                        products.add(0, currentProduct);
                    }
                    break;
                case "Unnecessary":
                    if (products.contains(currentProduct)) {
                        products.remove(currentProduct);
                    } else {
                        break;
                    }
                    break;
                case "Correct":
                    String newProduct = commands[2];
                    if (products.contains(currentProduct)) {
                        products.set(products.indexOf(currentProduct), newProduct);
                    } else {
                        break;
                    }
                    break;
                case "Rearrange":
                    if (products.contains(currentProduct)) {
                        products.remove(currentProduct);
                        products.add(products.size(), currentProduct);
                    } else {
                        break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(products.toString().replaceAll("[\\[\\]]", ""));
    }
}
