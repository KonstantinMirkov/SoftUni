package com.JavaFundamentals.ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Craft!")){
            String[] commands = input.split(" - ");
            String command = commands[0];
            String currentItem = commands[1];

            switch (command){
                case"Collect":
                    if (items.contains(currentItem)){
                        break;
                    }else{
                        items.add(currentItem);
                    }
                    break;
                case"Drop":
                    String itemToDrop = commands[1];
                    if(items.contains(currentItem)){
                        items.remove(itemToDrop);
                    }
                    break;
                case"Combine Items":
                    String[] combineItems = currentItem.split(":");
                    String oldItem = combineItems[0];
                    String newItem = combineItems[1];

                    if(items.contains(oldItem)){
                        items.add(items.size(), newItem);
                    }
                    break;
                case"Renew":
                    if (items.contains(currentItem)){
                        items.remove(currentItem);
                        items.add(currentItem);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(items.toString().replaceAll("[\\[\\]]", ""));
    }
}
