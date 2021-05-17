package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Character> openBrackets = new ArrayDeque<>();

        String input = scanner.nextLine();

        boolean balancedBrackets = true;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                openBrackets.push(currentBracket);
            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') {
                if (openBrackets.isEmpty()) {
                    balancedBrackets = false;
                    break;
                } else {
                    char openBracket = openBrackets.pop();
                    if (currentBracket == '}' && openBracket != '{') {
                        balancedBrackets = false;
                    } else if (currentBracket == ']' && openBracket != '[') {
                        balancedBrackets = false;
                    } else if (currentBracket == ')' && openBracket != '(') {
                        balancedBrackets = false;
                    }
                }
            }
        }
        print(balancedBrackets);
    }

    private static void print(boolean balancedBrackets) {
        if (balancedBrackets) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}