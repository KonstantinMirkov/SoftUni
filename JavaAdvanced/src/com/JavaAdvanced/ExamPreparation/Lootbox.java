package com.JavaAdvanced.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Първата кутия е опашка.
        Deque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Втората кутия е стек.
        Deque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int totalSum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek(); //Взима първия item от първата кутия.
            int secondItem = secondBox.pop(); // Взима последния item от втората кутия и го премахва от втората кутия.

            int currentSum = firstItem + secondItem;
            //Четна сума
            if (currentSum % 2 == 0) {
                totalSum += currentSum; //Преизчислявам текущата сума към общата.
                firstBox.poll(); //Премахвам и този item, който е в първата кутия.
            }
            //Нечетна сума
            else {
                firstBox.offer(secondItem); //добавям последния item от втората кутия в първата.
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (totalSum >= 100) {
            System.out.println("Your loot was epic! Value: " + totalSum);
        } else {
            System.out.println("Your loot was poor... Value: " + totalSum);
        }
    }
}
