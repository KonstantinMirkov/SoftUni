package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");

        Deque<Integer> numbersToCalculate = new ArrayDeque<>();

        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (Character.isDigit(element.charAt(0))) {
                numbersToCalculate.push(Integer.parseInt(element));
            } else {
                int rightOperand = Integer.parseInt(elements[++i]);
                int leftOperand = numbersToCalculate.peek();
                numbersToCalculate.push(rightOperand);

                int result = element.equals("+")
                        ? leftOperand + rightOperand
                        : leftOperand - rightOperand;
                numbersToCalculate.push(result);
            }
        }
        System.out.println(numbersToCalculate.peek());
    }
}