package com.JavaAdvanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> browserHistory = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());

                }
            } else if (input.equals("forward")) {
                if (forward.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    browserHistory.push(forward.pop());
                }
            } else {
                System.out.println(input);
                browserHistory.push(input);
                forward.clear();

            }
            input = scanner.nextLine();
        }
    }
}

