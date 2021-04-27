package com.JavaFundamentals.ExerciseAssociativeArrays;

import java.util.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resource = sc.nextLine();
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();
        UntilStop(sc, resource, resourcesQuantity);
        Print(resourcesQuantity);
    }

    private static void Print(Map<String, Integer> resourcesQuantity) {
        resourcesQuantity.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static void UntilStop(Scanner sc, String resource, Map<String, Integer> resourcesQuantity) {
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(sc.nextLine());
            ResourcesCases(resource, resourcesQuantity, quantity);

            resource = sc.nextLine();
        }

    }

    private static void ResourcesCases(String resource, Map<String, Integer> resourcesQuantity, int quantity) {
        if (!resourcesQuantity.containsKey(resource)) {
            resourcesQuantity.put(resource, quantity);

        } else {
            resourcesQuantity.put(resource, resourcesQuantity.get(resource) + quantity);
        }
    }
}
