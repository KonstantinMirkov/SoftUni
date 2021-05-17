package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        Deque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '(') {
                indexes.push(i);
            } else if (symbol == ')') {
                int beginIndex = indexes.pop();
                System.out.println(expression.substring(beginIndex, i + 1));
            }
        }
    }
}