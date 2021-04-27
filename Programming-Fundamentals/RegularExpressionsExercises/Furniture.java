package com.JavaFundamentals.RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        List<String> furnitureList = new ArrayList<>();
        double totalSum = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureList.add(furniture);

                totalSum = getTotalSum(totalSum, price, quantity);
            }
            input = scanner.nextLine();
        }
        print(furnitureList, totalSum);
    }

    private static double getTotalSum(double totalSum, double price, int quantity) {
        totalSum += price * quantity;
        return totalSum;
    }

    private static void print(List<String> furnitureList, double totalSum) {
        System.out.println("Bought furniture:");
        furnitureList.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
