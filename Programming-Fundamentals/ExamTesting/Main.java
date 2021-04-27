package com.JavaFundamentals.ExamTesting;


import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "add to start":
                    int indexToAddAtStart = Integer.parseInt(commands[1]);
                    integerList.add(0, indexToAddAtStart);
                    break;
                case "add to end":
                    int indexToAddAtEnd = Integer.parseInt(commands[1]);
                    integerList.add(integerList.size(), indexToAddAtEnd);
                    break;
                case "remove lower than":
                    int removeLowerIndex = Integer.parseInt(commands[1]);
                    for (int i = 0; i < integerList.size(); i++) {
                        if (integerList.get(i) < removeLowerIndex) {
                            integerList.remove(i);
                            i--;
                        }
                    }
                    break;
                case "remove greater than":
                    int removeGreaterIndex = Integer.parseInt(commands[1]);
                    for (int i = 0; i < integerList.size(); i++) {
                        if (integerList.get(i) > removeGreaterIndex) {
                            integerList.remove(i);
                            i--;
                        }
                    }
                    break;
                case "replace":
                    int valueToReplace = Integer.parseInt(commands[1]);
                    int replacementValue = Integer.parseInt(commands[2]);
                    for (int i = 0; i < integerList.size(); i++) {
                        if (integerList.get(i).equals(valueToReplace)) {
                            integerList.remove(valueToReplace);
                            integerList.add(valueToReplace, replacementValue);
                        }
                    }
                    break;
                case "remove at index":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    if (indexToRemove <= integerList.size()) {
                        integerList.remove(indexToRemove);
                    } else {
                        break;
                    }
                    break;
                case "remove count":
                    LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(integerList);
                    integerList = new ArrayList<>(hashSet);
                    break;
                case "find even":
                    for (int i = 0; i < integerList.size(); i++) {
                        if (integerList.get(i) % 2 == 0) {
                            System.out.print(integerList.get(i) + ", ");
                        }
                    }
                    break;
                case "find odd":
                    for (int i = 0; i < integerList.size(); i++) {
                        if (integerList.get(i) % 2 != 0) {
                            System.out.print(integerList.get(i) + ", ");
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(Arrays.toString(new List[]{integerList}).replaceAll("[\\[\\]]", ""));
    }
}