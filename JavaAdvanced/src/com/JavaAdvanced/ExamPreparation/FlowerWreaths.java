package com.JavaAdvanced.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Стек:
        Deque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);
        //Опашка:
        Deque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreathsCount = 0;
        int totalSum = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lastLilly = lilies.peek();
            int firstRose = roses.peek();

            int sum = lastLilly + firstRose;
            if (sum == 15) {
                wreathsCount++; // +1 Flower wreath
                lilies.pop(); // премахвам от върха на стека
                roses.poll(); // премахвам от края на опашката

            } else if (sum > 15) {
                lilies.pop(); // премахвам от върха на стака
                lastLilly -= 2; //наламявам числото с 2
                lilies.push(lastLilly); // връщам обратно намаленото число в стака
            } else {
                totalSum += sum; //запазвам остатъка от цветя
                lilies.pop(); // премахвам от върха на стака
                roses.poll(); // премахвам от края на опашката
            }
        }
        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        } else {
            int moreWreaths = (totalSum / 15); //Цветята, които ми липсват.
            int wreathsNeeded = 5 - (wreathsCount + moreWreaths); //необходимите wreaths, които не ми достигат за 5 броя.
            System.out.printf("You didn't make it, you need %d wreaths more!", wreathsNeeded);
        }
    }
}
