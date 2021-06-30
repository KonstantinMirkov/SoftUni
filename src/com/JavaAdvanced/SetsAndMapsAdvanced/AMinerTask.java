package com.JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();

        String resource = scanner.nextLine();

        collectingResources(scanner, resourcesQuantity, resource);
        print(resourcesQuantity);
    }

    private static void collectingResources(Scanner scanner, Map<String, Integer> resourcesQuantity, String resource) {
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesQuantity.containsKey(resource)) {
                resourcesQuantity.put(resource, quantity);

            } else {
                resourcesQuantity.put(resource, resourcesQuantity.get(resource) + quantity);
            }
            resource = scanner.nextLine();
        }
    }

    private static void print(Map<String, Integer> resourcesQuantity) {
        resourcesQuantity.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
