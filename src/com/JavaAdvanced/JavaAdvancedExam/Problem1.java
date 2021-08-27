package com.JavaAdvanced.JavaAdvancedExam;

import java.util.*;

public class Problem1 {
    //public static int biscuit = 25, cake = 50, pastry = 75, pie = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] liquids = implementArray(scanner);
        int[] ingredients = implementArray(scanner);


        ArrayDeque<Integer> ingredientDeque = new ArrayDeque<>();
        Arrays.stream(ingredients).forEach(ingredientDeque::push);

        ArrayDeque<Integer> liquidDeque = new ArrayDeque<>();
        Arrays.stream(liquids).forEach(liquidDeque::offer);


        Map<String, Integer> productValues = new LinkedHashMap<>();
        productValues.put("Biscuit", 0);
        productValues.put("Cake", 0);
        productValues.put("Pie", 0);
        productValues.put("Pastry", 0);

        while (!liquidDeque.isEmpty() && !ingredientDeque.isEmpty()) {
            int liquidOne = liquidDeque.poll();
            int lastIngredientLast = ingredientDeque.pop();

            int sum = liquidOne + lastIngredientLast;

            int countOfFoods;
            String foodName;
            if (sum == 25) {
                foodName = "Biscuit";
                countOfFoods = productValues.get(foodName);
                productValues.put(foodName, countOfFoods + 1);
            } else if (sum == 50) {
                foodName = "Cake";
                countOfFoods = productValues.get(foodName);
                productValues.put(foodName, countOfFoods + 1);
            } else if (sum == 75) {
                foodName = "Pie";
                countOfFoods = productValues.get(foodName);
                productValues.put(foodName, countOfFoods + 1);
            } else if (sum == 100) {
                foodName = "Pastry";
                countOfFoods = productValues.get(foodName);
                productValues.put(foodName, countOfFoods + 1);
            } else {
                lastIngredientLast += 3;
                ingredientDeque.push(lastIngredientLast);
            }
        }


        if (productValues.containsValue(0)) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }

        if (liquidDeque.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + String.join(", ", String.valueOf(liquidDeque)
                    .replaceAll("[\\[\\]]", "")));
        }

        if (ingredientDeque.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: "+ String.join(", ", String.valueOf(ingredientDeque)
                    .replaceAll("[\\[\\]]", "")));
        }


        productValues.forEach((foodsName, count) -> System.out.printf("%s: %d%n", foodsName, count));
    }

    private static int[] implementArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    }
}
