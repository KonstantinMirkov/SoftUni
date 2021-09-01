package com.JavaAdvanced.ExamPreparation;

import java.util.*;
import java.util.stream.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Опашка
        Deque<String> vegetables = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Стек
        Deque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(calories::push);

        List<Integer> finishedSalads = new ArrayList<>();
        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int saladCalories = calories.pop();
            finishedSalads.add(saladCalories);
            while (!vegetables.isEmpty() && saladCalories > 0) {
                switch (vegetables.poll()) {
                    case "tomato":
                        saladCalories -= 80;
                        break;
                    case "carrot":
                        saladCalories -= 136;
                        break;
                    case "lettuce":
                        saladCalories -= 109;
                        break;
                    case "potato":
                        saladCalories -= 215;
                        break;
                }
            }
        }
        System.out.println(finishedSalads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        if (!vegetables.isEmpty()) {
            System.out.println(vegetables.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        if (!calories.isEmpty()) {
            System.out.println(calories.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
