package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Double>> productShopData = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] shopInfo = input.split(", ");
            String shopName = shopInfo[0];
            String product = shopInfo[1];
            double price = Double.parseDouble(shopInfo[2]);
            productShopData.putIfAbsent(shopName, new LinkedHashMap<>());
            LinkedHashMap<String, Double> innerShopData = productShopData.get(shopName);
            innerShopData.putIfAbsent(product, price);

            input = scanner.nextLine();
        }
        print(productShopData);
    }
    private static void print(Map<String, LinkedHashMap<String, Double>> countriesData) {
        for (var entry : countriesData.entrySet()) {
            String shopName = entry.getKey();
            LinkedHashMap<String, Double> innerMap = entry.getValue();
            System.out.println(shopName + "->");
            for (var innerEntry : innerMap.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",  innerEntry.getKey() , innerEntry.getValue());
            }
        }
    }
}
