package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class InfixtoPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (String input : inputLine) {
                if (Character.isDigit(input.charAt(0)) || Character.isLetter(input.charAt(0))) {
                    numbers.offer(input);
                } else {
                    if (operators.isEmpty()) {
                        operators.push(input);
                    } else {
                        String lastOperator = operators.peek();
                        switch (input) {
                            case "+":
                            case "-":
                                if (lastOperator.equals("(")) {
                                    operators.push(input);
                                } else {
                                    numbers.offer(operators.pop());
                                    operators.push(input);
                                }
                                break;
                            case "*":
                            case "/":
                                if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                    numbers.offer(operators.pop());
                                }
                                operators.push(input);
                                break;
                            case "(":
                                operators.push(input);
                                break;
                            case ")":
                                while (!Objects.equals(operators.peek(), "(")) {
                                    numbers.offer(operators.pop());
                                }

                                operators.pop();
                                break;
                        }
                    }
                }
            }

            while (!numbers.isEmpty()) {
                System.out.print(numbers.poll() + " ");
            }

            while (!operators.isEmpty()) {
                System.out.print(operators.pop() + " ");
            }

    }
}
