package com.JavaAdvanced;

import java.util.*;

public class Main {
       // public static long[] fibonacciInfo;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    String[] inputLine = scanner.nextLine().split("\\s+");
    ArrayDeque<String> expression = new ArrayDeque<>();
    ArrayDeque<String> operators = new ArrayDeque<>();

        for (String input : inputLine) {
        if (Character.isDigit(input.charAt(0)) || Character.isLetter(input.charAt(0))) {
            expression.offer(input);
        } else {
            if (operators.isEmpty()) {
                operators.push(input);
            } else {
                String lastOperator = operators.peek();
                switch (input) {
                    case "+":
                    case "-":
                        if (!lastOperator.equals("(")) {
                            expression.offer(operators.pop());
                        }
                        operators.push(input);
                        break;
                    case "*":
                    case "/":
                        if (lastOperator.equals("*") || lastOperator.equals("/")) {
                            expression.offer(operators.pop());
                        }
                        operators.push(input);
                        break;
                    case "(":
                        operators.push(input);
                        break;
                    case ")":
                        while (!Objects.equals(operators.peek(), "(")) {
                            expression.offer(operators.pop());
                        }

                        operators.pop();
                        break;
                }
            }
        }
    }

            while (!expression.isEmpty()) {
        System.out.print(expression.poll() + " ");
    }

            while (!operators.isEmpty()) {
        System.out.print(operators.pop() + " ");
    }
            System.out.println();
        }
}
