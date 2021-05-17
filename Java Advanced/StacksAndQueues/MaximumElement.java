package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stackOfNumbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            int[] commands = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int command = commands[0];
            switch (command){
                case 1:
                    int numberToAdd = commands[1];
                    stackOfNumbers.push(numberToAdd);
                    break;
                case 2:
                    stackOfNumbers.pop();
                    break;
                case 3:
                    int maximumElement = Collections.max(stackOfNumbers);
                    System.out.println(maximumElement);
                    break;

            }
        }
    }
}