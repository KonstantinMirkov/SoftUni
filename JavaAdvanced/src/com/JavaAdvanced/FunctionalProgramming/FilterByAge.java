package com.JavaAdvanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> peopleData = new LinkedHashMap<>();

        getPeopleCount(scanner, n, peopleData);

        String ageCondition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        peopleData.entrySet().stream()
                .filter(getAgeFilter(ageCondition, age)).forEach(getPrintFormat(format));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintFormat(String format) {
        if (format.equals("name")) {
            return e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            return e -> System.out.println(e.getValue());
        } else {
            return e -> System.out.println(e.getKey() + " - " + e.getValue());
        }
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(String ageCondition, int age) {
        if (ageCondition.equals("older")) {
            return e -> e.getValue() >= age;
        } else {
            return e -> e.getValue() <= age;
        }
    }

    private static void getPeopleCount(Scanner scanner, int n, Map<String, Integer> peopleData) {
        while (n-- > 0) {
            String[] personStats = scanner.nextLine().split(", ");
            String name = personStats[0];
            int age = Integer.parseInt(personStats[1]);
            peopleData.put(name, age);
        }
    }
}
