package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> elements = new TreeMap<>
                (Map.of("fragments", 0, "shards", 0, "motes", 0));
        Map<String, Integer> junk = new TreeMap<>();
        label:
        while (true) {
            List<String> input = Arrays.asList(scanner.nextLine().toLowerCase().split(" "));
            for (int i = 1; i < input.size(); i = i + 2) {
                String type = input.get(i);
                int size = Integer.parseInt(input.get(i - 1));

                switch (input.get(i)) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        elements.put(type, elements.get(type) + size);
                        if (elements.get(type) >= 250) {
                            elements.put(type, elements.get(type) - 250);
                            if (type.equals("fragments")) System.out.println("Valanyr obtained!");
                            if (type.equals("shards")) System.out.println("Shadowmourne obtained!");
                            if (type.equals("motes")) System.out.println("Dragonwrath obtained!");
                            break label;
                        }
                        break;
                    default:
                        junk.putIfAbsent(type, 0);
                        junk.put(type, junk.get(type) + size);
                        break;
                }
            }
        }
        Print(elements, junk);
    }

    private static void Print(Map<String, Integer> elements, Map<String, Integer> junk) {
        elements.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(a -> System.out.printf("%s: %d%n", a.getKey(), a.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
