package com.JavaAdvanced.IteratorsАndComparators.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        while (!command.equals("END")) {
            String[] commands = command.split("[, ]+");

            switch (commands[0]) {
                case "Push":
                    for (int i = 1; i < commands.length; i++) {
                        stack.push(Integer.parseInt(commands[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("No elements");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (int i = 1; i <= 2; i++) {
            for (int number : stack) {
                System.out.println(number);
            }
        }
    }
}
