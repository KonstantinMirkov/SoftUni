package com.JavaAdvanced.StacksAndQueues;

import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        Deque<String> memoryDeque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            String argument = "";
            if (commands.length > 1) {
                argument = commands[1];
            }
            switch (command) {
                case "1":
                    memoryDeque.push(text.toString());
                    text.append(argument);
                    break;
                case "2":
                    memoryDeque.push(text.toString());
                    int count = Integer.parseInt(argument);
                    int start = text.length() - count;
                    text.delete(start, start + count);
//                    for (int j = 0; j < count; j++) {
//                        text = new StringBuilder(text.substring(0, text.length()
//                                - 1));
//                    }
                    break;
                case "3":
                    int index = Integer.parseInt(argument);
                    System.out.println(getIndex(text, index));
                    break;
                case "4":
                    if (!memoryDeque.isEmpty()) {
                        text = new StringBuilder(memoryDeque.pop());
                    }
                    break;
            }
        }
    }

    private static char getIndex(StringBuilder text, int index) {
        return text.charAt(index - 1);
    }
}
