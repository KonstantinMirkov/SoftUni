package com.JavaFundamentals.ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countCommands = Integer.parseInt(sc.nextLine());
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= countCommands; i++) {
            String command = sc.nextLine();
            // {name} is going!
            // {name} is not going!
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            if (tokens[2].equals("going!")) {
                if (names.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    names.add(name);
                }
            } else if (tokens[2].equals("not")) {
                if (names.contains(name)) {
                    names.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }

            }
        }
        printList(names);
    }

    static void printList(List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
