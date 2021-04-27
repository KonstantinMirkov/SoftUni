package com.JavaFundamentals.RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";

        Pattern patter = Pattern.compile(regex);

        double totalIncome = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = patter.matcher(input);
            while (matcher.find()) {
                double count = Double.parseDouble(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f%n", matcher.group("name"), matcher.group("product"), count * price);
                totalIncome += count * price;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f%n", totalIncome);
    }
}
