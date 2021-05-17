package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            numbers.push(Integer.parseInt(input[i]));
        }
        Collections.reverse(Collections.singletonList(numbers));

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
