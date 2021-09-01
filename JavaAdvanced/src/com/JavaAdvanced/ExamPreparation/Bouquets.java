package com.JavaAdvanced.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);
        //Опашка:
        Deque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquetsCount = 0;
        int totalSum = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int lastTulips = tulips.peek();
            int firstDaffodils = daffodils.peek();
            int sum = lastTulips + firstDaffodils;

            if (sum == 15) {
                bouquetsCount++; // +1 Flower wreath
                tulips.pop(); // премахвам от върха на стека
                daffodils.poll(); // премахвам от края на опашката
            } else if (sum > 15) {
                tulips.pop(); // премахвам от върха на стака
                lastTulips -= 2; //наламявам числото с 2
                tulips.push(lastTulips); // връщам обратно намаленото число в стака
            } else {
                totalSum += sum; //запазвам остатъка от цветя
                tulips.pop(); // премахвам от върха на стака
                daffodils.poll(); // премахвам от края на опашката
            }
        }
        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        } else {
            int moreBouquets = (totalSum / 15); //Цветята, които ми липсват.
            int bouquetsNeeded = 5 - (bouquetsCount + moreBouquets); //необходимите букети, които не ми достигат за 5 броя.
            System.out.printf("You failed... You need more %d bouquets.", bouquetsNeeded);
        }
    }
}
