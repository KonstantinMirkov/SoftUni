package com.JavaAdvanced.Generics.CustomListSorter;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ModifiedList<String> listOfCommands = new ModifiedList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "Add":
                    listOfCommands.add(commands[1]);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commands[1]);
                    listOfCommands.remove(index);
                    break;
                case "Contains":
                    System.out.println(listOfCommands.contains(commands[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commands[1]);
                    int secondIndex = Integer.parseInt(commands[2]);

                    listOfCommands.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(listOfCommands.countGreaterThan(commands[1]));
                    break;
                case "Max":
                    System.out.println(listOfCommands.getMax());
                    break;
                case "Min":
                    System.out.println(listOfCommands.getMin());
                    break;
                case "Sort":
                    listOfCommands.Sort();
                    break;
                case "Print":
                    listOfCommands.forEach(System.out::println);
            }
            input = scanner.nextLine();
        }
    }
}
