package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberCommands = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = numberCommands[0];
        int s = numberCommands[1];
        int x = numberCommands[2];

        Deque<Integer> stackOfNumbers = new ArrayDeque<>();

        int[] numbersInput = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        addNumbers(n, stackOfNumbers, numbersInput);

        removeNumbers(s, stackOfNumbers);

        printSmallestNumber(x, stackOfNumbers);
    }


    private static void addNumbers(int n, Deque<Integer> stackOfNumbers, int[] numbersInput) {
        for (int i = 0; i < n; i++) {
            int numberToAdd = numbersInput[i];
            stackOfNumbers.push(numberToAdd);
        }
    }

    private static void removeNumbers(int s, Deque<Integer> stackOfNumbers) {
        while (s > 0 && !stackOfNumbers.isEmpty()) {
            stackOfNumbers.pop();
            s--;
        }
    }

    private static void printSmallestNumber(int x, Deque<Integer> stackOfNumbers) {
            if (stackOfNumbers.isEmpty()) {
                System.out.println("0");
            } else if (stackOfNumbers.contains(x)) {
                System.out.println("true");
            } else {
                int smallestNumber = getSmallestNumber(stackOfNumbers);
                System.out.println(smallestNumber);
            }
        }


    private static int getSmallestNumber(Deque<Integer> stackOfNumbers) {
        int smallestNumber = Integer.MAX_VALUE;
        while (!stackOfNumbers.isEmpty()) {
            smallestNumber = Math.min(smallestNumber, stackOfNumbers.pop());
        }
        return smallestNumber;
    }
}