package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        ProductsOrders();
    }

    private static void ProductsOrders() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
        BeforeInputBuy(sc, input, productsPrice, productsQuantity);
        Print(productsPrice, productsQuantity);
    }

    private static void BeforeInputBuy(Scanner sc, String input, Map<String, Double> productsPrice, Map<String, Integer> productsQuantity) {
        while (!input.equals("buy")) {
            String product = input.split(" ")[0];
            double priceOfTheProduct = Double.parseDouble(input.split(" ")[1]);
            int quantityOfProduct = Integer.parseInt(input.split(" ")[2]);
            productsPrice.put(product, priceOfTheProduct);
            IfContainsQuantity(productsQuantity, product, quantityOfProduct);
            input = sc.nextLine();
        }
    }

    private static void IfContainsQuantity(Map<String, Integer> productsQuantity, String product, int quantityOfProduct) {
        if (!productsQuantity.containsKey(product)) {
            productsQuantity.put(product, quantityOfProduct);
        } else {
            productsQuantity.put(product, productsQuantity.get(product) + quantityOfProduct);
        }
    }

    private static void Print(Map<String, Double> productsPrice, Map<String, Integer> productsQuantity) {
        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            double finalSum = entry.getValue() * productsQuantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n",entry.getKey(), finalSum );
        }
    }

}
