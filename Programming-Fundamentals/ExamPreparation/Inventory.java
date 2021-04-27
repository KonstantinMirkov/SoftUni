package com.JavaFundamentals.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> journal = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("Craft!")) {
            String[] command = input.split(" - ");
            String commands = command[0];
            String item = command[1];
            int index = journal.indexOf(item);
            switch (commands) {
                case "Collect":
                    if (journal.contains(item)) {
                        break;
                    } else if (index < 0) {
                        journal.add(item);
                    }
                    break;
                case "Drop":
                    if (0 <= index && index < journal.size()) {
                        journal.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] combineItems = item.split(":");
                    String oldItem = combineItems[0];
                    String newItem = combineItems[1];
                    index = journal.indexOf(oldItem) + 1;
                    if (journal.contains(oldItem)) {
                        journal.add(index, newItem);
                    }
                    break;
                case "Renew":
                    if (journal.contains(item) && 0 <= index && index < journal.size()) {
                        journal.remove(item);
                        journal.add(item);
                    }
                    break;
                default:
                    break;
            }
            input = sc.nextLine();
        }

        System.out.print(journal.toString().

                replaceAll("[\\[\\]]", ""));
    }
}
